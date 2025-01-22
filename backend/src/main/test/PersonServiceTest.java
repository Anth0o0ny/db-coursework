import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.anth0o0ny.backend.dto.entitiesDto.CoachDto;
import com.anth0o0ny.backend.dto.entitiesDto.PersonDto;
import com.anth0o0ny.backend.dto.entitiesDto.SportsmanDto;
import com.anth0o0ny.backend.entities.Coach;
import com.anth0o0ny.backend.entities.Sportsman;
import com.anth0o0ny.backend.enums.Rank;
import com.anth0o0ny.backend.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class PersonServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSportsmanByName_Success() {
        String fullName = "John Doe";
        Sportsman sportsman = new Sportsman(1, fullName, new Date(), Rank.I_Y, 101);
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(sportsman));

        List<PersonDto> result = personService.getSportsmanByName(fullName);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(fullName, result.get(0).getFullName());
    }

    @Test
    public void testGetSportsmanByName_NotFound() {
        String fullName = "Unknown";
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.emptyList());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> personService.getSportsmanByName(fullName));
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
    }

    @Test
    public void testGetSportsmanById_Success() {
        int id = 1;
        Sportsman sportsman = new Sportsman(id, "John Doe", new Date(), Rank.CMS, 101);
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(sportsman));

        List<SportsmanDto> result = personService.getSportsmanById(id);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(id, result.get(0).getId());
    }

    @Test
    public void testGetSportsmanById_NotFound() {
        int id = 1;
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.emptyList());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> personService.getSportsmanById(id));
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
    }

    @Test
    public void testGetCoachByName_Success() {
        String fullName = "Jane Doe";
        Coach coach = new Coach(1, fullName, new Date(), 101);
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(coach));

        List<PersonDto> result = personService.getCoachByName(fullName);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(fullName, result.get(0).getFullName());
    }

    @Test
    public void testGetCoachByName_NotFound() {
        String fullName = "Unknown";
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.emptyList());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> personService.getCoachByName(fullName));
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
    }

    @Test
    public void testGetCoachById_Success() {
        int id = 1;
        Coach coach = new Coach(id, "Jane Doe", new Date(), 101);
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.singletonList(coach));

        List<CoachDto> result = personService.getCoachById(id);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(id, result.get(0).getId());
    }

    @Test
    public void testGetCoachById_NotFound() {
        int id = 1;
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(RowMapper.class)))
                .thenReturn(Collections.emptyList());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> personService.getCoachById(id));
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
    }
}
