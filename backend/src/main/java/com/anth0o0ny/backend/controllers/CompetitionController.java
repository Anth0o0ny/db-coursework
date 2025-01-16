package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Competition;
import com.anth0o0ny.backend.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.COMPETITIONS)
public class CompetitionController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }
}
