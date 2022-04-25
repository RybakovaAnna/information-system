package ru.ibs.training.informationsystem.services;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.RejectEquipmentRequestDto;
import ru.ibs.training.informationsystem.model.enums.Status;
import ru.ibs.training.informationsystem.model.request.EquipmentRequestEntity;
import ru.ibs.training.informationsystem.repositories.request.EquipmentRequestRepository;
import ru.ibs.training.informationsystem.services.interfaces.Mapper;
import ru.ibs.training.informationsystem.services.interfaces.RequestService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("RequestService")
public class RequestServiceImpl implements RequestService {

    private EquipmentRequestRepository requestRepository;
    private Mapper mapper;

    @Autowired
    public RequestServiceImpl(EquipmentRequestRepository requestRepository, Mapper mapper) {
        this.requestRepository = requestRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EquipmentRequestDto> findAll() {
        List<EquipmentRequestEntity> entityList = requestRepository.findAll();
        return entityList
                .stream()
                .map(e -> mapper.toDto(e))
                .collect(Collectors.toList());

    }

    @Override
    public EquipmentRequestDto findById(UUID id) {
        return mapper.toDto(requestRepository.findById(
                Long.parseLong(id.toString())
        )
                .orElse(null));
    }

    @Override
    public void deleteById(UUID id) {
        requestRepository.deleteById(
                Long.parseLong(id.toString())
        );
    }

    @Override
    public void updateById(UUID id, EquipmentRequestDto requestDto) {
        EquipmentRequestEntity requestEntity = mapper.toEntity(requestDto);
        requestEntity.setId(id);
        requestRepository.save(requestEntity);
    }

    @Override
    public void createNewRequest(EquipmentRequestEntity request) {
        EquipmentRequestEntity requestEntity = request;
        request.setStatus(String.valueOf(Status.NEW));
        requestRepository.save(requestEntity);
    }

    @Override
    public void approveRequest(UUID id) {
        EquipmentRequestEntity requestEntity = requestRepository.getById(
                Long.parseLong(id.toString())
        );
        requestEntity.setStatus(Status.APPROVED.toString());
        requestRepository.save(requestEntity);
    }

    @Override
    public void rejectRequest(RejectEquipmentRequestDto dto) {
        EquipmentRequestEntity requestEntity = requestRepository.getById(
                Long.parseLong(dto.getId().toString())
        );
        requestEntity.setStatus(Status.REJECTED.toString());
        requestEntity.setComment(dto.getReason());
        requestRepository.save(requestEntity);
    }
}
