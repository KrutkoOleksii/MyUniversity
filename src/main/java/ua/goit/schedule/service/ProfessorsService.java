package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.repository.ProfessorsRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfessorsService implements BaseService<Professor,Long>{

    private final ProfessorsRepository professorsRepository;

    @Override
    public Collection<Professor> findAll() {
        return professorsRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return professorsRepository.findById(id);
    }

    @Override
    public Professor save(Professor professor) {
        return professorsRepository.save(professor);
    }

    @Override
    public void deleteById(Long id) {
        professorsRepository.deleteById(id);
    }

}
