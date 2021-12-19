package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.service.LectureService;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/lecture")
public class LectureController {

    private final LectureService lectureService;

    @GetMapping(value = {"","/"})
    public Collection<Lecture> findAll(){
        return lectureService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<Lecture> findById(@PathVariable Long id){
        return lectureService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public Lecture save(@RequestBody Lecture daySchedule){
        return lectureService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        lectureService.deleteById(id);
    }

    @GetMapping(value = {"/day/{dayOfWeekNumber}/student/{studentId}"})
    public Collection<Lecture> getSchedule(@PathVariable int dayOfWeekNumber, @PathVariable Long studentId){
        return lectureService.getSchedule(DayOfWeek.of(dayOfWeekNumber), studentId);
    }

}
