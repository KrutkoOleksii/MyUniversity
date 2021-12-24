package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.service.GroupSchedulesService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/group-schedules")
public class GroupSchedulesController {

    private final GroupSchedulesService groupSchedulesService;

    @GetMapping(value = {"","/"})
    public Collection<GroupSchedule> findAll(){
        return groupSchedulesService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<GroupSchedule> findById(@PathVariable Long id){
        return groupSchedulesService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public GroupSchedule save(@RequestBody GroupSchedule groupSchedule){
        return groupSchedulesService.save(groupSchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        groupSchedulesService.deleteById(id);
    }

}
