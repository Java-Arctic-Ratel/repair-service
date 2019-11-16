package com.epam.repair.service.mapper;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RepairOrderMapper {
    List<RepairOrderDTO> repairOrderToOrderDTO(List<RepairOrder> repairOrders);
}