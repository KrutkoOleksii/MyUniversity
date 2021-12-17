package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.StudyGroupRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudyGroupService implements BaseService<StudyGroup,Long>{

    private final StudyGroupRepository studyGroupRepository;

    @Override
    public Collection<StudyGroup> findAll(){
        return studyGroupRepository.findAll();
    }

    @Override
    public Optional<StudyGroup> findById(Long id) {
        return studyGroupRepository.findById(id);
    }

    @Override
    public StudyGroup save(StudyGroup studyGroup){
        return studyGroupRepository.save(studyGroup);
    }

    @Override
    public void deleteById(Long id) {
        studyGroupRepository.deleteById(id);
    }

//    public StudyGroup add(StudyGroup studyGroup){
//        if (studyGroupRepository.existsById(studyGroup.getId())) return update(studyGroup);
//        return save(studyGroup);
//    }
//
//    public StudyGroup update(StudyGroup studyGroup){
//        if (studyGroupRepository.existsById(studyGroup.getId())) return save(studyGroup);
//        return
//    }

}
