package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.DaySchedule;

public interface LectureRepository extends JpaRepository<DaySchedule,Long> {

    //@Query("SELECT c FROM Note c WHERE NOT (c.accessType='PRIVATE' AND c.author.id!=?1)")
}
