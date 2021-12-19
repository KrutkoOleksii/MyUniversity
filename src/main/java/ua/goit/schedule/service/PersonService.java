package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.repository.PersonRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonService implements BaseService<Person,Long>{

    private final PersonRepository personRepository;

    @Override
    public Collection<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
