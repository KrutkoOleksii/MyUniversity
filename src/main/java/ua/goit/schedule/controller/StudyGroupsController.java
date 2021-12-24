package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.service.StudyGroupService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/groups")
public class StudyGroupsController {

    private final StudyGroupService studyGroupService;

    @GetMapping(value = {"","/"})
    public Collection<StudyGroup> findAll(){
        return studyGroupService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<StudyGroup> findById(@PathVariable Long id){
        return studyGroupService.findById(id);
    }

    @PostMapping(value = {"","/"})
    public StudyGroup save(@RequestBody StudyGroup studyGroup){
        return studyGroupService.save(studyGroup);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        studyGroupService.deleteById(id);
    }

}
