package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value="Error", discriminator = "error")
@Schema(name = "Error")
@Data
@AllArgsConstructor
public class ErrorDto {

    @JsonProperty
    @ApiModelProperty(
            name = "Код ошибки"
    )
    private Integer code;

    @JsonProperty
    @ApiModelProperty(
            name = "Описание ошибки"
    )
    private String message;

}
