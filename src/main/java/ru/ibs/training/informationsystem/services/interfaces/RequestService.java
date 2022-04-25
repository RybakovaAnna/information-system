package ru.ibs.training.informationsystem.services.interfaces;

import org.springframework.stereotype.Component;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.RejectEquipmentRequestDto;
import ru.ibs.training.informationsystem.model.request.EquipmentRequestEntity;

import java.util.List;
import java.util.UUID;

public interface RequestService {

    List<EquipmentRequestDto> findAll();

    EquipmentRequestDto findById(UUID id);

    void deleteById(UUID id);

    void updateById(UUID id, EquipmentRequestDto requestDto);

    void createNewRequest(EquipmentRequestEntity request);

    void approveRequest(UUID id);

    void rejectRequest(RejectEquipmentRequestDto dto);
}
