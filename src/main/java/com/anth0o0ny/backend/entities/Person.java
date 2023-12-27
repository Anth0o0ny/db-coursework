package com.anth0o0ny.backend.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {

    private int id;

    private String name;

    public Person() {}

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
