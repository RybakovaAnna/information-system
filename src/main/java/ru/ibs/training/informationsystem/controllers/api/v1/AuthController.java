package ru.ibs.training.informationsystem.controllers.api.v1;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.AuthDto;
import ru.ibs.training.informationsystem.controllers.api.v1.dtos.TokenDto;
import ru.ibs.training.informationsystem.services.interfaces.JwtService;

import java.util.Collections;
import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

    private final JwtService jwtService;

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
        Algorithm algo = Algorithm.HMAC256("1234");
        return new TokenDto(
                JWT.create()
                        .withIssuer("IBS")
                        .withClaim("roles", Collections.singletonList("ROLE_USER"))
                        .withExpiresAt(
                                new Date(System.currentTimeMillis() + 1000L * 3600))
                        .sign(algo));
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