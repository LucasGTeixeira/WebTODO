package com.lucasgteixeira.WebTODO.domain.model.task;

public enum TaskStatus {
    TODO ("A fazer"),
    DOING("Fazendo"),
    DONE("Feito");

    final String text;

    TaskStatus(String text) {
        this.text = text;
    }
}
