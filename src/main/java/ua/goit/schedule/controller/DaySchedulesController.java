package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.service.DaySchedulesService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/day-schedules")
public class DaySchedulesController {

    private final DaySchedulesService daySchedulesService;

    @GetMapping(value = {"","/"})
    public Collection<DaySchedule> findAll(){
        return daySchedulesService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<DaySchedule> findById(@PathVariable Long id){
        return daySchedulesService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public DaySchedule save(@RequestBody DaySchedule daySchedule){
        return daySchedulesService.save(daySchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        daySchedulesService.deleteById(id);
    }

}
