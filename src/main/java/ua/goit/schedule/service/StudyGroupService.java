package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.StudyGroupRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudyGroupService {

    private final StudyGroupRepository studyGroupRepository;

    public Collection<StudyGroup> getAll(){
        return studyGroupRepository.findAll();
    }

    public Optional<StudyGroup> findById(Long id) {
        return studyGroupRepository.findById(id);
    }

    public StudyGroup save(StudyGroup studyGroup){
        return studyGroupRepository.save(studyGroup);
    }
}
