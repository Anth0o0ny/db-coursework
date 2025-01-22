import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.anth0o0ny.backend.Constants;
import com.anth0o0ny.backend.database.DB;
import com.anth0o0ny.backend.dto.entitiesDto.SportschoolDto;
import com.anth0o0ny.backend.entities.Sportschool;
import com.anth0o0ny.backend.enums.PoolSize;
import com.anth0o0ny.backend.service.SchoolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

public class SchoolServiceTest {

    @Mock
    private DB db;

    @InjectMocks
    private SchoolService schoolService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSchoolByName_Success() {
        String name = "Olympic Pool";
        Sportschool school = new Sportschool(1, name, PoolSize._50);
        when(db.getSchoolByName(name)).thenReturn(Collections.singletonList(school));

        List<SportschoolDto> result = schoolService.getSchoolByName(name);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(name, result.get(0).getName());
    }

    @Test
    public void testGetSchoolByName_NotFound() {
        String name = "Unknown School";
        when(db.getSchoolByName(name)).thenReturn(Collections.emptyList());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> schoolService.getSchoolByName(name));
        assertEquals("404 NOT_FOUND", exception.getStatusCode().toString());
    }

    @Test
    public void testGetSchoolByName_ErrorHandling() {
        String name = "Error School";
        when(db.getSchoolByName(name)).thenThrow(new RuntimeException("Database error"));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> schoolService.getSchoolByName(name));
        assertEquals("500 INTERNAL_SERVER_ERROR", exception.getStatusCode().toString());
    }
}
