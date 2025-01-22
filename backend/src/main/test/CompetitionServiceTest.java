import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.CompetitionDto;
import com.anth0o0ny.backend.entities.Competition;
import com.anth0o0ny.backend.service.CompetitionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetitionServiceTest {

    @Mock
    private DB db;

    @InjectMocks
    private CompetitionService competitionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCompetitionsWhenCompetitionsExist() {
        Competition competition = new Competition(1, "Competition1", "Pool1", new Date(), new Date(), null);
        when(db.getAllCompetitions()).thenReturn(Arrays.asList(competition));
        List<CompetitionDto> result = competitionService.getAllCompetitions();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Competition1", result.get(0).getName());
        verify(db, times(1)).getAllCompetitions();
    }

    @Test
    void getAllCompetitionsWhenNoCompetitionsExist() {
        when(db.getAllCompetitions()).thenReturn(Arrays.asList());
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> competitionService.getAllCompetitions());
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
        verify(db, times(1)).getAllCompetitions();
    }

    @Test
    void getAllCompetitionsWhenExceptionOccurs() {
        when(db.getAllCompetitions()).thenThrow(new RuntimeException());
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> competitionService.getAllCompetitions());
        assertEquals("500 INTERNAL_SERVER_ERROR", exception.getStatusCode().toString());
        verify(db, times(1)).getAllCompetitions();
    }
}
