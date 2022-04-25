package ru.ibs.training.informationsystem.controllers.api.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ErrorDto;

import java.sql.SQLException;


/*
TODO: уточнить, какие исключения нужно обрабатывать и точнее настроить обработчик
 */
@RestControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(value = {
            Exception.class,
    })
    public ErrorDto dataBaseException(Exception err) {
        err.printStackTrace();
        return new ErrorDto(1, err.getMessage());
    }
}
