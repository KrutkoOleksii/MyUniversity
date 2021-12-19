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
import ua.goit.schedule.repository.PersonRepository;

@ContextConfiguration(classes = {PersonService.class})
@ExtendWith(SpringExtension.class)
class PersonServiceTest {
    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    void testFindAll() {
        when(this.personRepository.findAll()).thenReturn(null);
        assertNull(this.personService.findAll());
        verify(this.personRepository).findAll();
    }

    @Test
    void testFindById() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");
        Optional<Person> ofResult = Optional.of(person);
        when(this.personRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Person> actualFindByIdResult = this.personService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.personRepository).findById((Long) any());
        assertTrue(this.personService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");
        when(this.personRepository.save((Person) any())).thenReturn(person);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");
        assertSame(person, this.personService.save(person1));
        verify(this.personRepository).save((Person) any());
        assertTrue(this.personService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.personRepository).deleteById((Long) any());
        this.personService.deleteById(123L);
        verify(this.personRepository).deleteById((Long) any());
        assertTrue(this.personService.findAll().isEmpty());
    }
}

