package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.service.StudentsService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/students")
public class StudentsController {

    private final StudentsService studentsService;

    @GetMapping(value = {"","/"})
    public Collection<Student> findAll(){
        return studentsService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Student> findById(@PathVariable Long id){
        return studentsService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public Student save(@RequestBody Student student){
        return studentsService.save(student);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        studentsService.deleteById(id);
    }
}
