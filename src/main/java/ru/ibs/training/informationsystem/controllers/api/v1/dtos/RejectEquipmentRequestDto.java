package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * Description
 *
 * @author bse71
 * Created on 27.03.2022
 * @since
 */
@ApiModel(value="RejectEquipmentRequest", discriminator = "rejectEquipmentRequestDto")
@Schema(name = "RejectEquipmentRequest")
@Data
public class RejectEquipmentRequestDto {

    @JsonProperty
    @ApiModelProperty(
            name = "Идентификатор",
            example = "12"
    )
    @NotNull
    private UUID id;

    @JsonProperty
    @ApiModelProperty(name = "Причина отказа")
    @NotBlank
    private String reason;
}
