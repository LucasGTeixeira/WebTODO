package com.lucasgteixeira.WebTODO.domain.model.task;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dataInicio;
    @Column(nullable = false)
    private LocalDate dataTermino;
    @Column(nullable = false)
    private TaskStatus taskStatus;

    public Task(Integer id, String name, LocalDate dataInicio, LocalDate dataTermino, TaskStatus taskStatus) {
        this.id = id;
        this.name = name;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.taskStatus = taskStatus;
    }

    public Task(String name, LocalDate dataInicio, LocalDate dataTermino, TaskStatus taskStatus) {
        this.name = name;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.taskStatus = taskStatus;
    }

    public Task() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", taskStatus=" + taskStatus +
                '}';
    }
}
