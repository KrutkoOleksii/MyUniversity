package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.service.DayScheduleService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/day-schedules")
public class DaySchedulesController {

    private final DayScheduleService dayScheduleService;

    @GetMapping(value = {"","/"})
    public Collection<DaySchedule> findAll(){
        return dayScheduleService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<DaySchedule> findById(@PathVariable Long id){
        return dayScheduleService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public DaySchedule save(@RequestBody DaySchedule daySchedule){
        return dayScheduleService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        dayScheduleService.deleteById(id);
    }

}
