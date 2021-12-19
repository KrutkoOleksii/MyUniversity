package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.service.GroupScheduleService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/groupschedule")
public class GroupScheduleController {

    private final GroupScheduleService groupScheduleService;

    @GetMapping(value = {"","/"})
    public Collection<GroupSchedule> findAll(){
        return groupScheduleService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<GroupSchedule> findById(@PathVariable Long id){
        return groupScheduleService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public GroupSchedule save(@RequestBody GroupSchedule groupSchedule){
        return groupScheduleService.save(groupSchedule);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        groupScheduleService.deleteById(id);
    }

}
