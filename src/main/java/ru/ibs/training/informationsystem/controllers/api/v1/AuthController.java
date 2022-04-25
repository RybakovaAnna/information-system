package ru.ibs.training.informationsystem.controllers.api.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.AuthDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.TokenDto;
import ru.ibs.training.informationsystem.security.service.JwtService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

    private final JwtService jwtService;

    @Autowired
    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    @ApiOperation("Авторизация пользователя")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят"),
                    @ApiResponse(code = 400, message = "Невалидный запрос"),
                    @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
            })
    @PostMapping(
            value = "/login",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public TokenDto login(
            @RequestBody
            @ApiParam(value = "Credentials", required = true)
                    AuthDto authDto) {

        return jwtService.authorise(authDto);
    }

    @ApiOperation("Выход пользователя")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Запрос принят")
            })
    @PostMapping("/logout")
    public void logout() {

    }

}
