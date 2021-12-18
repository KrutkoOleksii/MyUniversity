package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.repository.LectureRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LectureService implements BaseService<DaySchedule,Long>{

    private final LectureRepository lectureRepository;

    @Override
    public Collection<DaySchedule> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    public Optional<DaySchedule> findById(Long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public DaySchedule save(DaySchedule daySchedule) {
        return lectureRepository.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        lectureRepository.deleteById(id);
    }
}
