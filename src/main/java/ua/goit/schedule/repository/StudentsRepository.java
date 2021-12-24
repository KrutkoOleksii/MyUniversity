package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Student;

public interface StudentsRepository extends JpaRepository<Student,Long> {
}
