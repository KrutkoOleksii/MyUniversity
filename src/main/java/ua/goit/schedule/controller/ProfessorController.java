package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.service.ProfessorService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/professor")
public class ProfessorController {

    private final ProfessorService professorService;


    @GetMapping(value = {"","/"})
    public Collection<Professor> getAll(){
        return professorService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Professor> getById(@PathVariable Long id){
        return professorService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Professor save(@RequestBody Professor professor){
        return professorService.save(professor);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        professorService.deleteById(id);
    }
}
