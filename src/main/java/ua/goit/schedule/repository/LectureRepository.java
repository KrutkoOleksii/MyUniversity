package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.Lecture;
import ua.goit.schedule.model.StudyGroup;

import java.util.Collection;

public interface LectureRepository extends JpaRepository<Lecture,Long> {

    @Query("SELECT c FROM Lecture c WHERE (c.daySchedule=?1)")
    Collection<Lecture> findByDaySchedule(DaySchedule daySchedule);

}
