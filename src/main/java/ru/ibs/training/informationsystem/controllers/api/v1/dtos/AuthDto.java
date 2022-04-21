package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

@ApiModel(value="Credentials", discriminator = "credentials")
@Schema(name = "Credentials")
public class AuthDto {

    @JsonProperty
    @ApiModelProperty(name = "Логин")
    @NotBlank
    private String login;

    @JsonProperty
    @ApiModelProperty(name = "Пароль")
    @NotBlank
    private String pass;

}
