package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.StudyGroup;

public interface StudyGroupsRepository extends JpaRepository<StudyGroup,Long> {
}
