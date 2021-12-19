package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.GroupSchedule;

import java.time.DayOfWeek;

public interface DayScheduleRepository extends JpaRepository<DaySchedule,Long> {

    @Query("SELECT c FROM DaySchedule c WHERE (c.dayOfWeek=?1 AND c.groupSchedule=?2)")
    DaySchedule getDaySchedule(DayOfWeek dayOfWeek, GroupSchedule groupSchedule);

}
