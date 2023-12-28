package com.anth0o0ny.backend.mapper;

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
            int trainingId = rs.getInt("trainingId");
            TrainingWithExercises training = trainingMap.get(trainingId);

            if (training == null) {
                training = new TrainingWithExercises();
                training.setId(trainingId);
                training.setCoachId(rs.getInt("coachId"));
                training.setSportsmanId(rs.getInt("sportsmanId"));
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
        exercise.setId(rs.getInt("exerciseId"));
        exercise.setDescription(rs.getString("description"));
        exercise.setCount(rs.getInt("count"));
        return exercise;
    }
}
