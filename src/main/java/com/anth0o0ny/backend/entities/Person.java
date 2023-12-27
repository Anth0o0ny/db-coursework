package com.anth0o0ny.backend.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person {

    private int id;

    private String fullName;

    public Person() {}

    public Person(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

}
