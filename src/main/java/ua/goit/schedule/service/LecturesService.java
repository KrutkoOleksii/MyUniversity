package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.repository.LecturesRepository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LecturesService implements BaseService<Lecture,Long>{

    private final LecturesRepository lecturesRepository;
    private final StudentsService studentsService;
    private final GroupSchedulesService groupSchedulesService;
    private final DaySchedulesService daySchedulesService;

    @Override
    public Collection<Lecture> findAll() {
        return lecturesRepository.findAll();
    }

    @Override
    public Optional<Lecture> findById(Long id) {
        return lecturesRepository.findById(id);
    }

    @Override
    public Lecture save(Lecture daySchedule) {
        return lecturesRepository.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        lecturesRepository.deleteById(id);
    }

    public Collection<Lecture> getSchedule(DayOfWeek dayOfWeek, Long studentId) {
        Student student = studentsService.findById(studentId).orElseThrow();
        return lecturesRepository.findByDaySchedule(
                        daySchedulesService.getDaySchedule(dayOfWeek,
                        groupSchedulesService.findByStudyGroup(student.getStudyGroup())));
    }

}
