package ru.ibs.training.informationsystem.controllers.api.v1.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@ApiModel(value = "EquipmentRequest", discriminator = "equipmentRequest")
@Schema(name = "EquipmentRequest")
public class EquipmentRequestDto {
    @JsonProperty
    @ApiModelProperty(
            name = "Идентификатор",
            example = "fd891389-332b-4f35-b347-549c5f0b1542"
    )
    private UUID id;

    @JsonProperty
    @ApiModelProperty(
            name = "Наименование оборудования",
            example = "Бур педальный"
    )
    private String title;

    @JsonProperty
    @ApiModelProperty(
            name = "Тип оборудования",
            example = "underground-equipment"
    )
    private Type type;

    @JsonProperty
    @ApiModelProperty(
            name = "Требуемое количество",
            example = "3"
    )
    private Integer amount;

    @JsonProperty
    @ApiModelProperty(name = "Дата")
    private Date date;

    @JsonProperty
    @ApiModelProperty(name = "Обоснование")
    private String comment;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public enum Type {
        GROUND("ground-equipment"),
        UNDERGROUND("underground-equipment");

        private static Map<String, Type> FORMAT_MAP = Stream
                .of(Type.values())
                .collect(toMap(s -> s.name, Function.<Type>identity()));

        private final String name;

        Type(String name) {
            this.name = name;
        }

        @JsonCreator
        public Type fromString(String string) {
            Type type = FORMAT_MAP.get(string);
            if (type == null) {
                throw new IllegalArgumentException(string + " has no corresponding value");
            }
            return type;
        }
    }
}
