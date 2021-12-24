package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.service.ProfessorService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/professors")
public class ProfessorsController {

    private final ProfessorService professorService;

    @GetMapping(value = {"","/"})
    public Collection<Professor> findAll(){
        return professorService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Professor> findById(@PathVariable Long id){
        return professorService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public Professor save(@RequestBody Professor professor){
        return professorService.save(professor);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        professorService.deleteById(id);
    }
}
