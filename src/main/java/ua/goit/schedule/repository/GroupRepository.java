package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {
}
