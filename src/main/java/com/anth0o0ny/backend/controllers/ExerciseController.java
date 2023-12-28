package com.anth0o0ny.backend.controllers;

import com.anth0o0ny.backend.entities.Exercise;
import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Training;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/training")
public class ExerciseController {

    @Autowired
    private DB db;

    @PostMapping("/exercisesByUserId")
    public List<TrainingWithExercises> getExercisesByUserId(@RequestBody Map<String, Integer> requestBody) {
        int userId = requestBody.get("userId");
        return db.getExercisesByUserId(userId);
    }
}

