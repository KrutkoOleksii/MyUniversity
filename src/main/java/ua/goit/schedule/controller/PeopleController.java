package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.service.PeopleService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/people")
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping(value = {"","/"})
    public Collection<Person> findAll(){
        return peopleService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Person> findById(@PathVariable Long id){
        return peopleService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public Person save(@RequestBody Person person){
        return peopleService.save(person);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        peopleService.deleteById(id);
    }
}
