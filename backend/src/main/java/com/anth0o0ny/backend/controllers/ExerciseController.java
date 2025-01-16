package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import com.anth0o0ny.backend.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.TRAININGS_PATH + "/{" + Constants.USER_ID + "}" + Constants.EXERCISES_PATH)
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<TrainingWithExercises> getExercisesByUserId(@PathVariable(Constants.USER_ID) int userId) {
        return exerciseService.getExercisesByUserId(userId);
    }
}


