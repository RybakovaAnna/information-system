package ru.ibs.training.informationsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;
import ru.ibs.training.informationsystem.model.enums.Status;
import ru.ibs.training.informationsystem.model.request.EquipmentRequestEntity;
import ru.ibs.training.informationsystem.repositories.request.EquipmentRequestRepository;
import ru.ibs.training.informationsystem.services.interfaces.Mapper;
import ru.ibs.training.informationsystem.services.interfaces.RequestService;

import java.util.List;
import java.util.stream.Collectors;


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
    public EquipmentRequestDto findById(Long id) {
        return mapper.toDto(requestRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, EquipmentRequestDto requestDto) {
        EquipmentRequestEntity requestEntity = mapper.toEntity(requestDto);
        requestEntity.setId(id);
        requestRepository.save(requestEntity);
    }

    @Override
    public void createNewRequest(EquipmentRequestDto requestDto) {
        EquipmentRequestEntity requestEntity = mapper.toEntity(requestDto);
        requestRepository.save(requestEntity);
    }

    @Override
    public void approveRequest(Long id) {
        EquipmentRequestEntity requestEntity = requestRepository.getById(id);
        requestEntity.setStatus(Status.APPROVED.toString());
    }

    @Override
    public void rejectRequest(Long id) {
        EquipmentRequestEntity requestEntity = requestRepository.getById(id);
        requestEntity.setStatus(Status.REJECTED.toString());
    }
}
