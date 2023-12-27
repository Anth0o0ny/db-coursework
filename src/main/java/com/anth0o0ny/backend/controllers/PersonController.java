package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private DB db;

    @PostMapping("/getSportsmanByName")
    public List<Person> getSportsmanByName(@RequestBody Map<String, String> requestBody) {
        String fullName = requestBody.get("fullName");
        return db.getSportsmanByName(fullName);
    }

    @PostMapping("/getCoach")
    public Person getCoach() {
        return new Person();
    }

}
