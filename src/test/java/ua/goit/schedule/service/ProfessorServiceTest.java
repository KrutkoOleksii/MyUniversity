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
import ua.goit.schedule.model.Person;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.repository.ProfessorRepository;

@ContextConfiguration(classes = {ProfessorService.class})
@ExtendWith(SpringExtension.class)
class ProfessorServiceTest {
    @MockBean
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService professorService;

    @Test
    void testFindAll() {
        when(this.professorRepository.findAll()).thenReturn(null);
        assertNull(this.professorService.findAll());
        verify(this.professorRepository).findAll();
    }

    @Test
    void testFindById() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");

        Professor professor = new Professor();
        professor.setId(123L);
        professor.setPerson(person);
        Optional<Professor> ofResult = Optional.of(professor);
        when(this.professorRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Professor> actualFindByIdResult = this.professorService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.professorRepository).findById((Long) any());
        assertTrue(this.professorService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");

        Professor professor = new Professor();
        professor.setId(123L);
        professor.setPerson(person);
        when(this.professorRepository.save((Professor) any())).thenReturn(professor);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");

        Professor professor1 = new Professor();
        professor1.setId(123L);
        professor1.setPerson(person1);
        assertSame(professor, this.professorService.save(professor1));
        verify(this.professorRepository).save((Professor) any());
        assertTrue(this.professorService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.professorRepository).deleteById((Long) any());
        this.professorService.deleteById(123L);
        verify(this.professorRepository).deleteById((Long) any());
        assertTrue(this.professorService.findAll().isEmpty());
    }
}

