package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.CoachDto;
import com.anth0o0ny.backend.dto.entitiesDto.PersonDto;
import com.anth0o0ny.backend.dto.entitiesDto.SportsmanDto;
import com.anth0o0ny.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(Constants.PERSONS_PATH)
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(Constants.SPORTS_MAN_NAME_PATH)
    public List<PersonDto> getSportsmanByName(@PathVariable(Constants.FULL_NAME) String fullName) {
        logger.info(Constants.LOG_GET_SPORTSMAN_BY_NAME, fullName);
        return personService.getSportsmanByName(fullName);
    }

    @GetMapping(Constants.SPORTS_MAN_ID_PATH)
    public List<SportsmanDto> getSportsmanById(@PathVariable(Constants.ID) int id) {
        logger.info(Constants.LOG_GET_SPORTSMAN_BY_ID, id);
        return personService.getSportsmanById(id);
    }

    @GetMapping(Constants.COACH_NAME_PATH)
    public List<PersonDto> getCoachByName(@PathVariable(Constants.FULL_NAME) String fullName) {
        logger.info(Constants.LOG_GET_COACH_BY_NAME, fullName);
        return personService.getCoachByName(fullName);
    }

    @GetMapping(Constants.COACH_ID_PATH)
    public List<CoachDto> getCoachById(@PathVariable(Constants.ID) int id) {
        logger.info(Constants.LOG_GET_COACH_BY_ID, id);
        return personService.getCoachById(id);
    }
}
