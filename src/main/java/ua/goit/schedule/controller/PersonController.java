package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Person;
import ua.goit.schedule.service.PersonService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = {"","/"})
    public Collection<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Person> findById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
