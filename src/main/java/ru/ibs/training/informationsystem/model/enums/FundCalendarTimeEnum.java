package ru.ibs.training.informationsystem.model.enums;

public enum FundCalendarTimeEnum {
    TOTAL("Всего скважин"),
    NEW("Всего скважин в том числе новых");

    private String name;

    FundCalendarTimeEnum() {
    }

    FundCalendarTimeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

