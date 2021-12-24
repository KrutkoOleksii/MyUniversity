package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Subject;
import ua.goit.schedule.repository.SubjectsRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SubjectsService implements BaseService<Subject,Long>{

    private final SubjectsRepository subjectsRepository;

    @Override
    public Collection<Subject> findAll() {
        return subjectsRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectsRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectsRepository.save(subject);
    }

    @Override
    public void deleteById(Long id) {
        subjectsRepository.deleteById(id);
    }

}
