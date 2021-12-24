package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.repository.AudiencesRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AudiencesService implements BaseService<Audience,Long>{

    private final AudiencesRepository audiencesRepository;

    @Override
    public Collection<Audience> findAll() {
        return audiencesRepository.findAll();
    }

    @Override
    public Optional<Audience> findById(Long id) {
        return audiencesRepository.findById(id);
    }

    @Override
    public Audience save(Audience audience) {
        return audiencesRepository.save(audience);
    }

    @Override
    public void deleteById(Long id) {
        audiencesRepository.deleteById(id);
    }
}
