package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Audience;

public interface AudiencesRepository extends JpaRepository<Audience,Long> {
}
