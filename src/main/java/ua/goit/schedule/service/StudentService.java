package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Student;
import ua.goit.schedule.repository.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentService implements BaseService<Student,Long>{

    private final StudentRepository studentRepository;

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
