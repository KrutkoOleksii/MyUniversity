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
import ua.goit.schedule.repository.AudienceRepository;

@ContextConfiguration(classes = {AudienceService.class})
@ExtendWith(SpringExtension.class)
class AudienceServiceTest {
    @MockBean
    private AudienceRepository audienceRepository;

    @Autowired
    private AudienceService audienceService;

    @Test
    void testFindAll() {
        when(this.audienceRepository.findAll()).thenReturn(null);
        assertNull(this.audienceService.findAll());
        verify(this.audienceRepository).findAll();
    }

    @Test
    void testFindById() {
        Optional<Audience> ofResult = Optional.of(Audience.builder()
                .id(123L)
                .name("Name")
                .build());
        when(this.audienceRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Audience> actualFindByIdResult = this.audienceService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.audienceRepository).findById((Long) any());
        assertTrue(this.audienceService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Audience audience = Audience.builder()
                .id(123L)
                .name("Name")
                .build();
        when(this.audienceRepository.save((Audience) any())).thenReturn(audience);

        Audience audience1 = Audience.builder()
                .id(123L)
                .name("Name")
                .build();
        assertSame(audience, this.audienceService.save(audience1));
        verify(this.audienceRepository).save((Audience) any());
        assertTrue(this.audienceService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.audienceRepository).deleteById((Long) any());
        this.audienceService.deleteById(123L);
        verify(this.audienceRepository).deleteById((Long) any());
        assertTrue(this.audienceService.findAll().isEmpty());
    }
}

