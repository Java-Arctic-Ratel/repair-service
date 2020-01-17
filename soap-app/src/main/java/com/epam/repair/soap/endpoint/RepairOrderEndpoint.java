package com.epam.repair.soap.endpoint;

import com.epam.repair.service.RepairOrderService;
import com.epam.repair.soap.converter.ModelConverter;
import com.epam.repairorder.*;
import org.springframework.context.annotation.Profile;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Profile({"!rest", "soap"})
@Endpoint
public class RepairOrderEndpoint {

    private final RepairOrderService repairOrderService;
    private final ModelConverter modelConverter;

    public RepairOrderEndpoint(RepairOrderService repairOrderService, ModelConverter modelConverter) {
        this.repairOrderService = repairOrderService;
        this.modelConverter = modelConverter;
    }

    @PayloadRoot(namespace = "http://epam.com/repairorder/", localPart = "getRepairOrderByIdRequest")
    @ResponsePayload
    public GetRepairOrderByIdResponse getRepairOrderByIdResponse(@RequestPayload GetRepairOrderByIdRequest request) {
        GetRepairOrderByIdResponse response = new GetRepairOrderByIdResponse();
        RepairOrder repairOrder = modelConverter.convertToCategoryForSoap(repairOrderService.findById(request.getRepairOrderId()));
        response.setRepairOrder(repairOrder);
        return response;
    }
}
