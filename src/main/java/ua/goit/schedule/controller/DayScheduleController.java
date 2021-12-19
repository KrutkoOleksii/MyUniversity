package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.service.DayScheduleService;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/dayschedule")
public class DayScheduleController {

    private final DayScheduleService dayScheduleService;

    @GetMapping(value = {"","/"})
    public Collection<DaySchedule> findAll(){
        return dayScheduleService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<DaySchedule> findById(@PathVariable Long id){
        return dayScheduleService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public DaySchedule save(@RequestBody DaySchedule daySchedule){
        return dayScheduleService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        dayScheduleService.deleteById(id);
    }

//    @GetMapping(value = {"/day/{dayOfWeekNumber}/student/{studentId}"})
//    public DaySchedule getSchedule(@PathVariable int dayOfWeekNumber, @PathVariable Long studentId){
//        return dayScheduleService.getSchedule(DayOfWeek.of(dayOfWeekNumber), studentId);
//    }
}
