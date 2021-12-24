package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.StudyGroupsRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudyGroupsService implements BaseService<StudyGroup,Long>{

    private final StudyGroupsRepository studyGroupsRepository;

    @Override
    public Collection<StudyGroup> findAll(){
        return studyGroupsRepository.findAll();
    }

    @Override
    public Optional<StudyGroup> findById(Long id) {
        return studyGroupsRepository.findById(id);
    }

    @Override
    public StudyGroup save(StudyGroup studyGroup){
        return studyGroupsRepository.save(studyGroup);
    }

    @Override
    public void deleteById(Long id) {
        studyGroupsRepository.deleteById(id);
    }

}
