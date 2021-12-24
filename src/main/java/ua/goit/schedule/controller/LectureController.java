package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.service.LecturesService;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/lectures")
public class LectureController {

    private final LecturesService lecturesService;

    @GetMapping(value = {"","/"})
    public Collection<Lecture> findAll(){
        return lecturesService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Lecture> findById(@PathVariable Long id){
        return lecturesService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public Lecture save(@RequestBody Lecture daySchedule){
        return lecturesService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        lecturesService.deleteById(id);
    }

    @GetMapping(value = {"/days/{dayOfWeekNumber}/students/{studentId}"})
    public Collection<Lecture> getSchedule(@PathVariable int dayOfWeekNumber, @PathVariable Long studentId){
        return lecturesService.getSchedule(DayOfWeek.of(dayOfWeekNumber), studentId);
    }

}
