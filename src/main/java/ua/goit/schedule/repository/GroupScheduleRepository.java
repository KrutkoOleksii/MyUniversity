package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.schedule.model.GroupSchedule;

public interface GroupScheduleRepository extends JpaRepository<GroupSchedule,Long> {

    @Query("SELECT c FROM GroupSchedule c WHERE (c.studyGroup.id=?1)")
    GroupSchedule findByStudyGroup(Long studyGroupId);
}
