package ru.ibs.training.informationsystem.services.interfaces;

import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.model.report.ReportEntity;
import ru.ibs.training.informationsystem.model.request.EquipmentRequestEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    ReportEntity toEntity(ReportDto reportDto);
    ReportDto toDto(ReportEntity reportEntity);

    EquipmentRequestEntity toEntity(EquipmentRequestDto equipmentRequestDto);
    EquipmentRequestDto toDto(EquipmentRequestEntity equipmentRequestEntity);
}
