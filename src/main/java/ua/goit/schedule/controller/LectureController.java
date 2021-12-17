package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.service.LectureService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/lecture")
public class LectureController {

    private final LectureService lectureService;


    @GetMapping(value = {"","/"})
    public Collection<Lecture> getAll(){
        return lectureService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Lecture> getById(@PathVariable Long id){
        return lectureService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Lecture save(@RequestBody Lecture lecture){
        return lectureService.save(lecture);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        lectureService.deleteById(id);
    }
}
