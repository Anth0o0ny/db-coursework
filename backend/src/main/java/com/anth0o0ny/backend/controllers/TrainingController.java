package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.service.ExerciseService;
import com.anth0o0ny.backend.service.TrainingService;
import com.anth0o0ny.backend.entities.request.ExerciseRequest;
import com.anth0o0ny.backend.entities.request.TrainingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.TRAININGS_PATH)
public class TrainingController {

    private static final Logger logger = LoggerFactory.getLogger(TrainingController.class);
    private final TrainingService trainingService;
    private final ExerciseService exerciseService;

    @Autowired
    public TrainingController(TrainingService trainingService, ExerciseService exerciseService) {
        this.trainingService = trainingService;
        this.exerciseService = exerciseService;
    }

    @PostMapping(Constants.CREATE_PATH)
    public ResponseEntity<String> createTraining(@RequestBody TrainingRequest trainingRequest) {
        logger.info(Constants.LOG_RECEIVED_CREATE_TRAINING, trainingRequest);
        try {
            int trainingId = trainingService.createTraining(trainingRequest.getCoachId(), trainingRequest.getSportsmanId());
            for (ExerciseRequest exerciseRequest : trainingRequest.getExercises()) {
                exerciseService.addExercise(exerciseRequest.getDescription(), exerciseRequest.getCount(), trainingId);
            }
            logger.info(Constants.LOG_TRAINING_CREATED_SUCCESSFULLY, trainingId);
            return ResponseEntity.ok(Constants.SUCCESS_TRAINING_CREATION);
        } catch (Exception e) {
            logger.error(Constants.LOG_ERROR_CREATING_TRAINING, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Constants.ERROR_TRAINING_CREATION);
        }
    }
}
