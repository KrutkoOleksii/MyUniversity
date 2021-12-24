package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.service.AudiencesService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/audiences")
public class AudiencesController {

    private final AudiencesService audiencesService;

    @GetMapping(value = {"","/"})
    public Collection<Audience> findAll(){
        return audiencesService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Audience> findById(@PathVariable Long id){
        return audiencesService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Audience save(@RequestBody Audience audience){
        return audiencesService.save(audience);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        audiencesService.deleteById(id);
    }

}
