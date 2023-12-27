package com.anth0o0ny.backend.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Task {

    private int id;

    private String description;

    public Task() {}

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

}
