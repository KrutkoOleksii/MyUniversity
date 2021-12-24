package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.model.StudyGroup;

public interface GroupSchedulesRepository extends JpaRepository<GroupSchedule,Long> {

    @Query("SELECT c FROM GroupSchedule c WHERE (c.studyGroup=?1)")
    GroupSchedule findByStudyGroup(StudyGroup studyGroup);
}
