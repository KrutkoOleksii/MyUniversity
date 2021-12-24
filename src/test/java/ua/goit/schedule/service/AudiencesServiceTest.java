package ua.goit.schedule.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.repository.AudiencesRepository;

@ContextConfiguration(classes = {AudiencesService.class})
@ExtendWith(SpringExtension.class)
class AudiencesServiceTest {
    @MockBean
    private AudiencesRepository audiencesRepository;

    @Autowired
    private AudiencesService audiencesService;

    @Test
    void testFindAll() {
        when(this.audiencesRepository.findAll()).thenReturn(null);
        assertNull(this.audiencesService.findAll());
        verify(this.audiencesRepository).findAll();
    }

    @Test
    void testFindById() {
        Optional<Audience> ofResult = Optional.of(Audience.builder()
                .id(123L)
                .name("Name")
                .build());
        when(this.audiencesRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Audience> actualFindByIdResult = this.audiencesService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.audiencesRepository).findById((Long) any());
        assertTrue(this.audiencesService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Audience audience = Audience.builder()
                .id(123L)
                .name("Name")
                .build();
        when(this.audiencesRepository.save((Audience) any())).thenReturn(audience);

        Audience audience1 = Audience.builder()
                .id(123L)
                .name("Name")
                .build();
        assertSame(audience, this.audiencesService.save(audience1));
        verify(this.audiencesRepository).save((Audience) any());
        assertTrue(this.audiencesService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.audiencesRepository).deleteById((Long) any());
        this.audiencesService.deleteById(123L);
        verify(this.audiencesRepository).deleteById((Long) any());
        assertTrue(this.audiencesService.findAll().isEmpty());
    }
}

