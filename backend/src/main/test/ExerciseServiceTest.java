import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.entities.Exercise;
import com.anth0o0ny.backend.entities.TrainingWithExercises;
import com.anth0o0ny.backend.dto.entitiesDto.TrainingWithExercisesDto;
import com.anth0o0ny.backend.dto.mapper.TrainingWithExercisesMapper;
import com.anth0o0ny.backend.service.ExerciseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExerciseServiceTest {

    private DB db;
    private JdbcTemplate jdbcTemplate;
    private ExerciseService exerciseService;

    @BeforeEach
    void setUp() {
        db = mock(DB.class);
        jdbcTemplate = mock(JdbcTemplate.class);
        exerciseService = new ExerciseService(db, jdbcTemplate);
    }

    @Test
    void getExercisesByUserId() {
        int userId = 1;
        TrainingWithExercises exercise = mock(TrainingWithExercises.class);
        when(exercise.getExercises()).thenReturn(Arrays.asList(new Exercise()));
        when(db.getExercisesByUserId(userId)).thenReturn(Arrays.asList(exercise));
        List<TrainingWithExercisesDto> result = exerciseService.getExercisesByUserId(userId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(db, times(1)).getExercisesByUserId(userId);
    }


    @Test
    void getExercisesByUserId_WhenExceptionOccurs() {
        int userId = 1;
        when(db.getExercisesByUserId(userId)).thenThrow(new RuntimeException("Database error"));
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> exerciseService.getExercisesByUserId(userId));
        assertEquals("500 INTERNAL_SERVER_ERROR", exception.getStatusCode().toString());
        verify(db, times(1)).getExercisesByUserId(userId);
    }

    @Test
    void addExerciseSuccessfully() {
        String description = "Push-ups";
        int count = 20;
        int trainingId = 1;
        assertDoesNotThrow(() -> exerciseService.addExercise(description, count, trainingId));
        verify(jdbcTemplate, times(1)).update(Constants.INSERT_EXERCISE, description, count, trainingId);
    }

    @Test
    void addExerciseWhenDescriptionIsEmpty() {
        String description = "";
        int count = 20;
        int trainingId = 1;

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> exerciseService.addExercise(description, count, trainingId));
        assertEquals("400 BAD_REQUEST", exception.getStatusCode().toString());
        verify(jdbcTemplate, times(0)).update(anyString(), any(), anyInt(), anyInt());
    }

    @Test
    void addExerciseWhenCountIsInvalid() {
        String description = "Push-ups";
        int count = 0;
        int trainingId = 1;

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> exerciseService.addExercise(description, count, trainingId));
        assertEquals("400 BAD_REQUEST", exception.getStatusCode().toString());
        verify(jdbcTemplate, times(0)).update(anyString(), any(), anyInt(), anyInt());
    }

    @Test
    void addExerciseWhenExceptionOccurs() {

        String description = "Push-ups";
        int count = 20;
        int trainingId = 1;
        doThrow(new RuntimeException("Database error")).when(jdbcTemplate).update(Constants.INSERT_EXERCISE, description, count, trainingId);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> exerciseService.addExercise(description, count, trainingId));
        assertEquals("500 INTERNAL_SERVER_ERROR", exception.getStatusCode().toString());
        verify(jdbcTemplate, times(1)).update(Constants.INSERT_EXERCISE, description, count, trainingId);
    }
}
