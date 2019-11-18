package com.epam.repair.service.mapper;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepairOrderMapper {
    RepairOrderDTO repairOrderToOrderDTO(RepairOrder repairOrders);
}