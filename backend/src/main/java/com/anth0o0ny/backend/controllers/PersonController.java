package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Person;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.PERSONS_PATH)
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(Constants.SPORTS_MAN_NAME_PATH)
    public List<Person> getSportsmanByName(@PathVariable(Constants.FULL_NAME) String fullName) {
        return personService.getSportsmanByName(fullName);
    }

    @GetMapping(Constants.SPORTS_MAN_ID_PATH)
    public List<Sportsman> getSportsmanById(@PathVariable(Constants.ID) int id) {
        return personService.getSportsmanById(id);
    }

    @GetMapping(Constants.COACH_NAME_PATH)
    public List<Person> getCoachByName(@PathVariable(Constants.FULL_NAME) String fullName) {
        return personService.getCoachByName(fullName);
    }

    @GetMapping(Constants.COACH_ID_PATH)
    public List<Coach> getCoachById(@PathVariable(Constants.ID) int id) {
        return personService.getCoachById(id);
    }
}
