package com.anth0o0ny.backend.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Training {

    private int id;

    private List<Task> tasks;

    public Training() {}

    public Training(int id, List<Task> tasks) {
        this.id = id;
        this.tasks = tasks;
    }

}
