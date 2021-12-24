package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.repository.PeopleRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PeopleService implements BaseService<Person,Long>{

    private final PeopleRepository peopleRepository;

    @Override
    public Collection<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return peopleRepository.findById(id);
    }

    @Override
    public Person save(Person person) {
        return peopleRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        peopleRepository.deleteById(id);
    }

}
