package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.StudyGroup;
import ua.goit.schedule.repository.GroupScheduleRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupScheduleService implements BaseService<GroupSchedule,Long>{

    private final GroupScheduleRepository groupScheduleRepository;

    @Override
    public Collection<GroupSchedule> findAll() {
        return groupScheduleRepository.findAll();
    }

    @Override
    public Optional<GroupSchedule> findById(Long id) {
        return groupScheduleRepository.findById(id);
    }

    @Override
    public GroupSchedule save(GroupSchedule groupSchedule) {
        return groupScheduleRepository.save(groupSchedule);
    }

    @Override
    public void deleteById(Long id) {
        groupScheduleRepository.deleteById(id);
    }

    public GroupSchedule findByStudyGroup(StudyGroup studyGroup){
        return groupScheduleRepository.findByStudyGroup(studyGroup);
    }
}
