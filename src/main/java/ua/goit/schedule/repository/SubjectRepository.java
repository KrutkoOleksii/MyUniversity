package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Long> {
}
