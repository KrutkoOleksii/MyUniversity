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
import ua.goit.schedule.repository.SubjectRepository;

@ContextConfiguration(classes = {SubjectService.class})
@ExtendWith(SpringExtension.class)
class SubjectServiceTest {
    @MockBean
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectService subjectService;

    @Test
    void testFindAll() {
        when(this.subjectRepository.findAll()).thenReturn(null);
        assertNull(this.subjectService.findAll());
        verify(this.subjectRepository).findAll();
    }

    @Test
    void testFindById() {
        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        Optional<Subject> ofResult = Optional.of(subject);
        when(this.subjectRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Subject> actualFindByIdResult = this.subjectService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.subjectRepository).findById((Long) any());
        assertTrue(this.subjectService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Subject subject = new Subject();
        subject.setId(123L);
        subject.setName("Name");
        when(this.subjectRepository.save((Subject) any())).thenReturn(subject);

        Subject subject1 = new Subject();
        subject1.setId(123L);
        subject1.setName("Name");
        assertSame(subject, this.subjectService.save(subject1));
        verify(this.subjectRepository).save((Subject) any());
        assertTrue(this.subjectService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.subjectRepository).deleteById((Long) any());
        this.subjectService.deleteById(123L);
        verify(this.subjectRepository).deleteById((Long) any());
        assertTrue(this.subjectService.findAll().isEmpty());
    }
}

