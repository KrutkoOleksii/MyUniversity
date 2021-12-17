package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.service.StudyGroupService;

import java.util.Collection;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/group")
public class StudyGroupController {

    private final StudyGroupService studyGroupService;

    @GetMapping(value = {"","/"})
    public Collection<StudyGroup> getAll(){
        return studyGroupService.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Optional<StudyGroup> getById(@PathVariable Long id){
        return studyGroupService.findById(id);
    }

    @PostMapping(value = {"/save"})
    public StudyGroup save(@RequestBody StudyGroup studyGroup){
        return studyGroupService.save(studyGroup);
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Long id) {
        studyGroupService.deleteById(id);
    }

}
