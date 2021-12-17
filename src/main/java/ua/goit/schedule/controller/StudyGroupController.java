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
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @GetMapping(value = {"","/"})
    public Collection<StudyGroup> getAll(){
        return studyGroupService.findAll();
    }

    @GetMapping(value = {"/group/{id}"})
    public Optional<StudyGroup> getById(@PathVariable Long id){
        return studyGroupService.findById(id);
    }

    @PostMapping(value = {"/group/save"})
    public StudyGroup save(StudyGroup studyGroup){
        return studyGroupService.save(studyGroup);
    }

}
