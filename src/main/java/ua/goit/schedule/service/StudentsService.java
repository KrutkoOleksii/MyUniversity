package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.repository.StudentsRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentsService implements BaseService<Student,Long>{

    private final StudentsRepository studentsRepository;

    @Override
    public Collection<Student> findAll() {
        return studentsRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentsRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentsRepository.deleteById(id);
    }

}
