package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Professor;

public interface ProfessorsRepository extends JpaRepository<Professor,Long> {
}
