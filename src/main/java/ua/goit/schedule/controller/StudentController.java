package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.service.StudentService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = {"","/"})
    public Collection<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Student> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
