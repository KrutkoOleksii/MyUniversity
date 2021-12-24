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
import ua.goit.schedule.repository.PeopleRepository;

@ContextConfiguration(classes = {PeopleService.class})
@ExtendWith(SpringExtension.class)
class PeopleServiceTest {
    @MockBean
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleService peopleService;

    @Test
    void testFindAll() {
        when(this.peopleRepository.findAll()).thenReturn(null);
        assertNull(this.peopleService.findAll());
        verify(this.peopleRepository).findAll();
    }

    @Test
    void testFindById() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");
        Optional<Person> ofResult = Optional.of(person);
        when(this.peopleRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Person> actualFindByIdResult = this.peopleService.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.peopleRepository).findById((Long) any());
        assertTrue(this.peopleService.findAll().isEmpty());
    }

    @Test
    void testSave() {
        Person person = new Person();
        person.setId(123L);
        person.setName("Name");
        person.setSurname("Doe");
        when(this.peopleRepository.save((Person) any())).thenReturn(person);

        Person person1 = new Person();
        person1.setId(123L);
        person1.setName("Name");
        person1.setSurname("Doe");
        assertSame(person, this.peopleService.save(person1));
        verify(this.peopleRepository).save((Person) any());
        assertTrue(this.peopleService.findAll().isEmpty());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.peopleRepository).deleteById((Long) any());
        this.peopleService.deleteById(123L);
        verify(this.peopleRepository).deleteById((Long) any());
        assertTrue(this.peopleService.findAll().isEmpty());
    }
}

