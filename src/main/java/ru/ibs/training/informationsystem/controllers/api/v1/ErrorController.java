package ru.ibs.training.informationsystem.controllers.api.v1;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.dao.DataAccessException;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.bind.annotation.RestControllerAdvice;
        import ru.ibs.training.informationsystem.controllers.api.v1.dtos.ErrorDto;

        import java.sql.SQLException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({Exception.class})
    public ErrorDto error(Exception err) {
        return new ErrorDto(5, "lol");
    }
}
