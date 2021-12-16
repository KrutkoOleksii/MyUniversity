package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.schedule.service.GroupService;

@RestController
@AllArgsConstructor
public class GroupController {

    private final GroupService groupService;


}
