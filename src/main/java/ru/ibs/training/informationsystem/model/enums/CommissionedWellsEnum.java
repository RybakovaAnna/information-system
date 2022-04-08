package ru.ibs.training.informationsystem.model.enums;

public enum CommissionedWellsEnum {
    OIL("Нефтяные"),
    EXPLORATION("Разведочные"),
    STANDARD_PUMP("Насосные"),
    ELECTRIC_PUMP("Электропогружные насосные"),
    COMPRESSOR("Компрессорные"),
    FOUNTAIN("Фонтанные"),
    INJECTION("Нагнетательные"),
    AFTER_WORKING("Нагнетательные из них после отработки на нефть");

    private String name;

    CommissionedWellsEnum() {
    }

    CommissionedWellsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

