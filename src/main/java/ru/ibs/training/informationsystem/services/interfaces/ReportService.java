package ru.ibs.training.informationsystem.services.interfaces;

import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.model.report.ReportEntity;

import java.util.Collection;

public interface ReportService {
    Collection<ReportEntity> getAllReports();

    ReportEntity getReport(Long id);

    void createReport(ReportDto reportDto);

    void updateReport(Long id, ReportDto reportDto);
}
