package ru.ibs.training.informationsystem.controllers.api.v1;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ReportDto;
import ru.ibs.training.informationsystem.services.interfaces.ConverterService;
import ru.ibs.training.informationsystem.services.interfaces.ReportService;

import java.io.FileNotFoundException;
import java.security.Principal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/equipment-report")
public class ReportController {

    private ReportService service;
    private ConverterService converterService;

    @Autowired
    public ReportController(ReportService service, ConverterService converterService) {
        this.service = service;
        this.converterService = converterService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT')")
    @ApiOperation("Получение всех отчетов")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @GetMapping(
            produces = APPLICATION_JSON_VALUE
    )
    public List<ReportDto> allReports(Principal principal) {
        System.out.println(principal);
        return service.getAllReports();
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT')")
    @ApiOperation("Получение отчета по id")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @GetMapping(
            value = "/{id}",
            produces = APPLICATION_JSON_VALUE
    )
    public ReportDto getOneReport(
            @PathVariable Long id) {
        return service.getReport(id);
    }

//    @ApiOperation("Редактирование отчета")
//    @ApiResponses(
//            value = {
//                    @ApiResponse(code = 200, message = "Запрос принят"),
//                    @ApiResponse(code = 400, message = "Невалидный запрос"),
//                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
//            })
//    @PutMapping(
//            value = "/{id}",
//            consumes = APPLICATION_JSON_VALUE
//    )
//    public void updateReport(
//            @PathVariable Long id,
//            @RequestBody ReportDto dto) {
//        service.updateReport(id, dto);
//    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @ApiOperation("Создание нефтяного отчета")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PostMapping(
            consumes = APPLICATION_JSON_VALUE
    )
    public void newReport(
            @RequestBody
            @ApiParam(value = "EquipmentRequest", required = true)
                    ReportDto reportDto) {
        service.createReport(reportDto);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @ApiOperation("Создание нефтяного отчета")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @GetMapping("/pdf")
    public Document createPDF(@PathVariable Long id) throws FileNotFoundException, DocumentException {
        return converterService.convertToPDF(id);
    }
}
