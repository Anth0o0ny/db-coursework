import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.service.TrainingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

public class TrainingServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private TrainingService trainingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTraining_Success() {
        int coachId = 1;
        int sportsmanId = 2;
        int lastTrainingId = 123;
        when(jdbcTemplate.update(Constants.INSERT_TRAINING, coachId, sportsmanId)).thenReturn(1);
        when(jdbcTemplate.queryForObject(Constants.SELECT_LAST_TRAINING_ID, Integer.class)).thenReturn(lastTrainingId);
        int result = trainingService.createTraining(coachId, sportsmanId);

        assertEquals(lastTrainingId, result);
        verify(jdbcTemplate).update(Constants.INSERT_TRAINING, coachId, sportsmanId);
        verify(jdbcTemplate).queryForObject(Constants.SELECT_LAST_TRAINING_ID, Integer.class);
    }

    @Test
    public void testCreateTraining_FailedToRetrieveLastTrainingId() {
        int coachId = 1;
        int sportsmanId = 2;
        when(jdbcTemplate.update(Constants.INSERT_TRAINING, coachId, sportsmanId)).thenReturn(1);
        when(jdbcTemplate.queryForObject(Constants.SELECT_LAST_TRAINING_ID, Integer.class)).thenReturn(0);
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            trainingService.createTraining(coachId, sportsmanId);
        });

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusCode());
        assertEquals(Constants.ERROR_FAILED_TO_RETRIEVE_LAST_TRAINING_ID, exception.getReason());
    }

    @Test
    public void testCreateTraining_ExceptionHandling() {
        int coachId = 1;
        int sportsmanId = 2;
        when(jdbcTemplate.update(Constants.INSERT_TRAINING, coachId, sportsmanId)).thenThrow(new RuntimeException("Database error"));
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            trainingService.createTraining(coachId, sportsmanId);
        });

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusCode());
        assertEquals(Constants.ERROR_CREATING_TRAINING, exception.getReason());
    }
}
