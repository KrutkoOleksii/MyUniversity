package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.repository.DayScheduleRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DayScheduleService implements BaseService<DaySchedule,Long>{

    private final DayScheduleRepository dayScheduleRepository;

    @Override
    public Collection<DaySchedule> findAll() {
        return dayScheduleRepository.findAll();
    }

    @Override
    public Optional<DaySchedule> findById(Long id) {
        return dayScheduleRepository.findById(id);
    }

    @Override
    public DaySchedule save(DaySchedule daySchedule) {
        return dayScheduleRepository.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        dayScheduleRepository.deleteById(id);
    }
}
