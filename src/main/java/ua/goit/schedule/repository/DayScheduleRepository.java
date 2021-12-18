package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.DaySchedule;

public interface DayScheduleRepository extends JpaRepository<DaySchedule,Long> {

}
