package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.service.StudyGroupsService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/groups")
public class StudyGroupsController {

    private final StudyGroupsService studyGroupsService;

    @GetMapping(value = {"","/"})
    public Collection<StudyGroup> findAll(){
        return studyGroupsService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<StudyGroup> findById(@PathVariable Long id){
        return studyGroupsService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public StudyGroup save(@RequestBody StudyGroup studyGroup){
        return studyGroupsService.save(studyGroup);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        studyGroupsService.deleteById(id);
    }

}
