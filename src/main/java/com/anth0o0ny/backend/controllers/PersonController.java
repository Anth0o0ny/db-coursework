package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.entities.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @PostMapping("/getSportsman")
    public Person getSportsman() {
        return new Person();
    }

    @PostMapping("/getCoach")
    public Person getCoach() {
        return new Person();
    }

}
