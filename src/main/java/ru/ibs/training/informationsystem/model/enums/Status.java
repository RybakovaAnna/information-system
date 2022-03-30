package ru.ibs.training.informationsystem.model.enums;

public enum Status {
    NEW("Новый"),
    APPROVED("Утвержден"),
    REJECTED("Отклонен");

    private String name;

    Status() {
    }

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

