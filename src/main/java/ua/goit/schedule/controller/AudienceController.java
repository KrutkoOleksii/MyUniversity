package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.goit.schedule.service.AudienceService;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/audience")
public class AudienceController {

    private final AudienceService audienceService;


}
