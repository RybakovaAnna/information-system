package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = "unknown")
public class ErrorDto {

    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;
}
