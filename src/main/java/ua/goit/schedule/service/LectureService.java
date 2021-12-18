package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.repository.LectureRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LectureService implements BaseService<Lecture,Long>{

    private final LectureRepository lectureRepository;

    @Override
    public Collection<Lecture> findAll() {
        return lectureRepository.findAll();
    }

    @Override
    public Optional<Lecture> findById(Long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public Lecture save(Lecture daySchedule) {
        return lectureRepository.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        lectureRepository.deleteById(id);
    }
}
