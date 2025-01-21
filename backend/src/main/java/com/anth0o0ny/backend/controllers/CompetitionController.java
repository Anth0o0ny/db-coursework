package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.CompetitionDto;
import com.anth0o0ny.backend.service.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.COMPETITIONS)
public class CompetitionController {

    private static final Logger logger = LoggerFactory.getLogger(CompetitionController.class);
    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<CompetitionDto> getAllCompetitions() {
        logger.info(Constants.LOG_GET_ALL_COMPETITIONS);
        return competitionService.getAllCompetitions();
    }
}
