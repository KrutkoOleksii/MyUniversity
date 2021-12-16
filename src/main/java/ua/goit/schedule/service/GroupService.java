package ua.goit.schedule.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.schedule.model.Group;
import ua.goit.schedule.repository.GroupRepository;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public Collection<Group> getAll(){
        return groupRepository.findAll();
    }

    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    public Group save(Group group){
        return groupRepository.save(group);
    }
}
