package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.service.SubjectService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping(value = {"","/"})
    public Collection<Subject> findAll(){
        return subjectService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Subject> findById(@PathVariable Long id){
        return subjectService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Subject save(@RequestBody Subject subject){
        return subjectService.save(subject);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        subjectService.deleteById(id);
    }
}
