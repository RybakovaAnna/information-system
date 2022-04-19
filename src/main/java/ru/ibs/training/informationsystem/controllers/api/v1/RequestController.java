package ru.ibs.training.informationsystem.controllers.api.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.EquipmentRequestDto;
import ru.ibs.training.informationsystem.services.interfaces.RequestService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/equipment-request")
public class RequestController {

    private RequestService service;

    @Autowired
    public RequestController(RequestService service) {
        this.service = service;
    }

    @ApiOperation("Получение всех заявок на оборудование")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @GetMapping(
            produces = APPLICATION_JSON_VALUE
    )
    public List<EquipmentRequestDto> allRequests() {
        return service.findAll();
    }

    @ApiOperation("Получение заявки по id")
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
    public EquipmentRequestDto getOneRequest(
            @PathVariable UUID id) {
        return service.findById(id);
    }

    @ApiOperation("Редактирование заявки")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PutMapping(
            value = "/{id}",
            consumes = APPLICATION_JSON_VALUE
    )
    public void update(
            @PathVariable UUID id,
            @RequestBody EquipmentRequestDto dto) {
        service.updateById(id, dto);
    }

    @ApiOperation("Удаление заявки")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(
            @PathVariable UUID id) {
        service.deleteById(id);
    }

    @ApiOperation("Заявка на получение оборудования")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PostMapping(
            consumes = APPLICATION_JSON_VALUE
    )
    public void newRequest(
            @RequestBody
            @ApiParam(value = "EquipmentRequest", required = true)
                    EquipmentRequestDto equipmentRequestDto) {
        service.createNewRequest(equipmentRequestDto);
    }

    @ApiOperation("Удовлетворение заявки")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PostMapping(
            value = "/{id}/approve",
            consumes = APPLICATION_JSON_VALUE
    )
    public void approve(
            @PathVariable UUID id) {
        service.approveRequest(id);
    }

    @ApiOperation("Отказ по заявке")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PostMapping("/{id}/reject")
    public void reject(
            @PathVariable UUID id) {
        service.rejectRequest(id);
    }

}
