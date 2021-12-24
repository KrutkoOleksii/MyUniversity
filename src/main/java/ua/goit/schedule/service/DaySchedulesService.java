package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.DaySchedule;
import ua.goit.schedule.model.GroupSchedule;
import ua.goit.schedule.repository.DaySchedulesRepository;

import java.time.DayOfWeek;
import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DaySchedulesService implements BaseService<DaySchedule,Long>{

    private final DaySchedulesRepository daySchedulesRepository;

    @Override
    public Collection<DaySchedule> findAll() {
        return daySchedulesRepository.findAll();
    }

    @Override
    public Optional<DaySchedule> findById(Long id) {
        return daySchedulesRepository.findById(id);
    }

    @Override
    public DaySchedule save(DaySchedule daySchedule) {
        return daySchedulesRepository.save(daySchedule);
    }

    @Override
    public void deleteById(Long id) {
        daySchedulesRepository.deleteById(id);
    }

    public DaySchedule getDaySchedule(DayOfWeek dayOfWeekNumber, GroupSchedule groupSchedule) {
        return daySchedulesRepository.getDaySchedule(dayOfWeekNumber, groupSchedule);
    }
}
