package ru.ibs.training.informationsystem.services.interfaces;

import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;

import java.util.Collection;
import java.util.List;

public interface ReportService {

    List<ReportDto> getAllReports();

    ReportDto getReport(Long id);

    void createReport(ReportDto reportDto);

    void updateReport(Long id, ReportDto reportDto);
}
