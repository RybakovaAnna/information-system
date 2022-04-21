package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@ApiModel(value="ApproveEquipmentRequest", discriminator = "approveEquipmentRequestDto")
@Schema(name = "ApproveEquipmentRequest")
@Data
public class ApproveEquipmentRequestDto {
    @JsonProperty
    @ApiModelProperty(name = "Дата")
    @NotNull
    private String date;
}
