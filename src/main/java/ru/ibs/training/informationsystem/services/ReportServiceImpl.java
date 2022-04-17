package ru.ibs.training.informationsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.model.report.ReportEntity;
import ru.ibs.training.informationsystem.repositories.report.ReportRepository;
import ru.ibs.training.informationsystem.services.interfaces.Mapper;
import ru.ibs.training.informationsystem.services.interfaces.ReportService;

import java.util.List;
import java.util.stream.Collectors;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;
    private Mapper mapper;

    @Autowired
    public ReportServiceImpl(ReportRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ReportDto> getAllReports(){
        List<ReportEntity> entityList = repository.findAll();
        return entityList
                .stream()
                .map(e -> mapper.toDto(e))
                .collect(Collectors.toList());
    }

    @Override
    public ReportDto getReport(Long id){
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public void createReport(ReportDto reportDto){
        repository.save(
                mapper.toEntity(reportDto)
        );
    }

    @Override
    public void updateReport(Long id, ReportDto reportDto){
        ReportEntity reportEntity = mapper.toEntity(reportDto);
        reportEntity.setId(id);
        repository.save(reportEntity);
    }
}
