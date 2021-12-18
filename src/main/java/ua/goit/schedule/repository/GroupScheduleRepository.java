package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.GroupSchedule;

public interface GroupScheduleRepository extends JpaRepository<GroupSchedule,Long> {

}
