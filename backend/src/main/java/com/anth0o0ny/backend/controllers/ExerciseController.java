package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.dto.entitiesDto.TrainingWithExercisesDto;
import com.anth0o0ny.backend.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(Constants.TRAININGS_PATH + "/{" + Constants.USER_ID + "}" + Constants.EXERCISES_PATH)
public class ExerciseController {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);
    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<TrainingWithExercisesDto> getExercisesByUserId(@PathVariable(Constants.USER_ID) int userId) {
        logger.info(Constants.LOG_GET_EXERCISES_BY_USER_ID, userId);
        return exerciseService.getExercisesByUserId(userId);
    }
}
