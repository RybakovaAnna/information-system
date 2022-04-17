package ru.ibs.training.informationsystem.services.interfaces;

import org.springframework.stereotype.Component;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;

import java.util.List;

@Component("RequestService")
public interface RequestService {

    List<EquipmentRequestDto> findAll();

    EquipmentRequestDto findById(Long id);

    void deleteById(Long id);

    void updateById(Long id, EquipmentRequestDto requestDto);

    void createNewRequest(EquipmentRequestDto requestDto);

    void approveRequest(Long id);

    void rejectRequest(Long id);
}
