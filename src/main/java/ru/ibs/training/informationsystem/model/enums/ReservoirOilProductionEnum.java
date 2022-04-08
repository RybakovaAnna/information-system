package ru.ibs.training.informationsystem.model.enums;

public enum ReservoirOilProductionEnum {
    TOTAL("Всего"),
    WATER_INJECTION("Закачки воды"),
    HYDRODYNAMIC("Закачки воды в том числе гидродинамические методы"),
    HEW("Новые методы "),
    PHYSICAL_CHEMICAl("физико-химические "),
    THERMAL("термические");

    private String name;

    ReservoirOilProductionEnum() {
    }

    ReservoirOilProductionEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

