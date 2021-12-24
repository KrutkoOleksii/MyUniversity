package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.service.ProfessorsService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/professors")
public class ProfessorsController {

    private final ProfessorsService professorsService;

    @GetMapping(value = {"","/"})
    public Collection<Professor> findAll(){
        return professorsService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Professor> findById(@PathVariable Long id){
        return professorsService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public Professor save(@RequestBody Professor professor){
        return professorsService.save(professor);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        professorsService.deleteById(id);
    }
}
