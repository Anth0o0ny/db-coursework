package com.anth0o0ny.backend.mapper;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.entities.Exercise;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingWithExercisesRowMapper implements RowMapper<List<TrainingWithExercises>> {

    @Override
    public List<TrainingWithExercises> mapRow(ResultSet rs, int rowNum) throws SQLException {
        Map<Integer, TrainingWithExercises> trainingMap = new HashMap<>();

        do {
            int trainingId = rs.getInt(Constants.TRAINING_ID);
            TrainingWithExercises training = trainingMap.get(trainingId);

            if (training == null) {
                training = new TrainingWithExercises();
                training.setId(trainingId);
                training.setCoachId(rs.getInt(Constants.COACH_ID));
                training.setSportsmanId(rs.getInt(Constants.SPORTSMAN_ID));
                training.setExercises(new ArrayList<>());
                trainingMap.put(trainingId, training);
            }

            Exercise exercise = mapExercise(rs);
            training.addExercise(exercise);

        } while (rs.next());

        return new ArrayList<>(trainingMap.values());
    }

    private Exercise mapExercise(ResultSet rs) throws SQLException {
        Exercise exercise = new Exercise();
        exercise.setId(rs.getInt(Constants.EXERCISE_ID));
        exercise.setDescription(rs.getString(Constants.DESCRIPTION));
        exercise.setCount(rs.getInt(Constants.COUNT));
        return exercise;
    }
}
