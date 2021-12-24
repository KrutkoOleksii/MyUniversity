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
import ua.goit.schedule.repository.ProfessorsRepository;

@ContextConfiguration(classes = {ProfessorsService.class})
@ExtendWith(SpringExtension.class)
class ProfessorsServiceTest {
    @MockBean
    private ProfessorsRepository professorsRepository;

    @Autowired
    private ProfessorsService professorsService;

    @Test
    void testFindAll() {
        when(this.professorsRepository.findAll()).thenReturn(null);
        assertNull(this.professorsService.findAll());
        verify(this.professorsRepository).findAll();
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
        when(this.professorsRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Professor> actualFindByIdResult = this.professorsService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.professorsRepository).findById((Long) any());
        assertTrue(this.professorsService.findAll().isEmpty());
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
        when(this.professorsRepository.save((Professor) any())).thenReturn(professor);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");

        Professor professor1 = new Professor();
        professor1.setId(123L);
        professor1.setPerson(person1);
        assertSame(professor, this.professorsService.save(professor1));
        verify(this.professorsRepository).save((Professor) any());
        assertTrue(this.professorsService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.professorsRepository).deleteById((Long) any());
        this.professorsService.deleteById(123L);
        verify(this.professorsRepository).deleteById((Long) any());
        assertTrue(this.professorsService.findAll().isEmpty());
    }
}

