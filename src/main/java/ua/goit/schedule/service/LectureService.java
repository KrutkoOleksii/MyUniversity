package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.repository.LectureRepository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LectureService implements BaseService<Lecture,Long>{

    private final LectureRepository lectureRepository;
    private final StudentService studentService;
    private final GroupScheduleService groupScheduleService;
    private final DayScheduleService dayScheduleService;

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

    public Collection<Lecture> getSchedule(DayOfWeek dayOfWeek, Long studentId) {
        Student student = studentService.findById(studentId).orElseThrow();
        return lectureRepository.findByDaySchedule(
                        dayScheduleService.getDaySchedule(dayOfWeek,
                        groupScheduleService.findByStudyGroup(student.getStudyGroup())));
    }

}
