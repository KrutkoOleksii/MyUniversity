package ua.goit.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.schedule.model.Person;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
