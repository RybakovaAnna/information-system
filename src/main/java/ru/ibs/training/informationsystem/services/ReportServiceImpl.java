package ru.ibs.training.informationsystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.model.report.ReportEntity;
import ru.ibs.training.informationsystem.repositories.report.ReportRepository;
import ru.ibs.training.informationsystem.services.interfaces.Mapper;
import ru.ibs.training.informationsystem.services.interfaces.ReportService;

import java.util.Collection;

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
    public Collection<ReportEntity> getAllReports(){
        return repository.findAll();
    }

    @Override
    public ReportEntity getReport(Long id){
        return repository.getById(id);
    }

    @Override
    public void createReport(ReportDto reportDto){
        repository.save(
                mapper.toEntity(reportDto)
        );
    }

    @Override
    public void updateReport(Long id, ReportDto reportDto){
        repository.save(
                mapper.toEntity(reportDto)
        );
    }
}
