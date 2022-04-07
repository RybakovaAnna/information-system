package ru.ibs.training.informationsystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.training.informationsystem.controller.dto.ReportDto;
import ru.ibs.training.informationsystem.mapper.ReportMapper;
import ru.ibs.training.informationsystem.repositories.report.ReportRepository;

@RestController
@AllArgsConstructor
@RequestMapping("report")
public class TestController {
    private ReportRepository reportRepository;
    private ReportMapper mapper;

    @GetMapping("/{id}")
    public ReportDto getReport(@PathVariable long id) {
        return mapper.toDto(reportRepository.findById(id).orElse(null));
    }
}
