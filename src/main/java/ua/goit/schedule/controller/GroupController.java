package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.Group;
import ua.goit.schedule.service.GroupService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/groups")
public class GroupController {

    private final GroupService groupService;

    @GetMapping(value = {"","/"})
    public Collection<Group> getAll(){
        return groupService.getAll();
    }

    @GetMapping(value = {"/group/{id}"})
    public Optional<Group> getById(@PathVariable Long id){
        return groupService.findById(id);
    }

    @PostMapping(value = {"/group/save"})
    public Group save(Group group){
        return groupService.save(group);
    }

}
