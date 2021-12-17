package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.repository.SubjectRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SubjectService implements BaseService<Subject,Long>{

    private final SubjectRepository subjectRepository;

    @Override
    public Collection<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

}
