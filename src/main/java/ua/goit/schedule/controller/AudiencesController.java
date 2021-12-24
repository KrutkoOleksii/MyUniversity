package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.service.AudienceService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/audiences")
public class AudiencesController {

    private final AudienceService audienceService;

    @GetMapping(value = {"","/"})
    public Collection<Audience> findAll(){
        return audienceService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Audience> findById(@PathVariable Long id){
        return audienceService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Audience save(@RequestBody Audience audience){
        return audienceService.save(audience);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        audienceService.deleteById(id);
    }

}
