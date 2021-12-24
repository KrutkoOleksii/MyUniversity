package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.GroupSchedulesRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupSchedulesService implements BaseService<GroupSchedule,Long>{

    private final GroupSchedulesRepository groupSchedulesRepository;

    @Override
    public Collection<GroupSchedule> findAll() {
        return groupSchedulesRepository.findAll();
    }

    @Override
    public Optional<GroupSchedule> findById(Long id) {
        return groupSchedulesRepository.findById(id);
    }

    @Override
    public GroupSchedule save(GroupSchedule groupSchedule) {
        return groupSchedulesRepository.save(groupSchedule);
    }

    @Override
    public void deleteById(Long id) {
        groupSchedulesRepository.deleteById(id);
    }

    public GroupSchedule findByStudyGroup(StudyGroup studyGroup){
        return groupSchedulesRepository.findByStudyGroup(studyGroup);
    }
}
