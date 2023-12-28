package com.anth0o0ny.backend.controllers;


import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/competition")
public class CompetitionController {

    @Autowired
    private DB db;

    @PostMapping("/getAllCompetitions")
    public List<Competition> getAllCompetitions() {
        return db.getAllCompetitions();
    }
}
