package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Audience;
import ua.goit.schedule.repository.AudienceRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AudienceService implements BaseService<Audience,Long>{

    private final AudienceRepository audienceRepository;

    @Override
    public Collection<Audience> findAll() {
        return audienceRepository.findAll();
    }

    @Override
    public Optional<Audience> findById(Long id) {
        return audienceRepository.findById(id);
    }

    @Override
    public Audience save(Audience audience) {
        return audienceRepository.save(audience);
    }

    @Override
    public void deleteById(Long id) {
        audienceRepository.deleteById(id);
    }
}
