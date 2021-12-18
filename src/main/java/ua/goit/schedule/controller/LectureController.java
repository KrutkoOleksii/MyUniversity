package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.service.LectureService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/lecture")
public class LectureController {

    private final LectureService lectureService;


    @GetMapping(value = {"","/"})
    public Collection<DaySchedule> getAll(){
        return lectureService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<DaySchedule> getById(@PathVariable Long id){
        return lectureService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public DaySchedule save(@RequestBody DaySchedule daySchedule){
        return lectureService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        lectureService.deleteById(id);
    }
}
