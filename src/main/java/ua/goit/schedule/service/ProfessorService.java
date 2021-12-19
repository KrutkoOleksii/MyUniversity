package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Professor;
import ua.goit.schedule.repository.ProfessorRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProfessorService implements BaseService<Professor,Long>{

    private final ProfessorRepository professorRepository;

    @Override
    public Collection<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public void deleteById(Long id) {
        professorRepository.deleteById(id);
    }

}
