package ru.ibs.training.informationsystem.model.enums;

public enum OilProductionEnum {
    STANDARD_PUMP("Добыча нефти насосами"),
    ELECTRIC_PUMP("Добыча нефти насосами в том числе электропогружными"),
    COMPRESSOR("Добыча нефти компрессорами"),
    FOUNTAIN("Добыча нефти фонтанами"),
    OTHER_WAYS("Добыча нефти прочими способами"),
    TOTAL("Итого"),
    OLD_WELLS("Добыча нефти из старых скважин"),
    OLD_OLD_WELLS("Добыча нефти из старых скважин в том числе перешедших с прошлого года"),
    NEW_WELLS("Добыча нефти из новых скважин"),
    RANDOM_OIL("Добыча шахтной, попутной и случайной нефти"),
    EXPLORATION_WELLS("Добыча шахтной, попутной и случайной нефти в том числе при опробовании разведочных скважин"),
    TOTAL_OIL_PRODUCED("Всего добыто нефти (без газового конденсата) ");

    private String name;

    OilProductionEnum() {
    }

    OilProductionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

