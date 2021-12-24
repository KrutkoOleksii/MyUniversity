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
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.repository.SubjectsRepository;

@ContextConfiguration(classes = {SubjectsService.class})
@ExtendWith(SpringExtension.class)
class SubjectsServiceTest {
    @MockBean
    private SubjectsRepository subjectsRepository;

    @Autowired
    private SubjectsService subjectsService;

    @Test
    void testFindAll() {
        when(this.subjectsRepository.findAll()).thenReturn(null);
        assertNull(this.subjectsService.findAll());
        verify(this.subjectsRepository).findAll();
    }

    @Test
    void testFindById() {
        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        Optional<Subject> ofResult = Optional.of(subject);
        when(this.subjectsRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Subject> actualFindByIdResult = this.subjectsService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.subjectsRepository).findById((Long) any());
        assertTrue(this.subjectsService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        when(this.subjectsRepository.save((Subject) any())).thenReturn(subject);

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        assertSame(subject, this.subjectsService.save(subject1));
        verify(this.subjectsRepository).save((Subject) any());
        assertTrue(this.subjectsService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.subjectsRepository).deleteById((Long) any());
        this.subjectsService.deleteById(123L);
        verify(this.subjectsRepository).deleteById((Long) any());
        assertTrue(this.subjectsService.findAll().isEmpty());
    }
}

