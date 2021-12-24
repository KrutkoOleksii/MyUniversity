package ua.goit.schedule.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/",""})
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        return "Endpoints:\n" +
                "\n" +
                "The main path:\n" +
                " - ‘localhost:8080’\n" +
                "\n" +
                "Then the path for the entities:\n" +
                "- ‘/audienses’\n" +
                "- ‘/day-schedules’\n" +
                "- ‘/group-schedules’\n" +
                "- ‘/lectures’\n" +
                "- ‘/people’\n" +
                "- ‘/professors’\n" +
                "- ‘/students’\n" +
                "- ‘/groups’\n" +
                "- ‘/subjects’\n" +
                "\n" +
                "And in the end for each entities (CRUD)\n" +
                "- GET (path ’’ or ‘/‘) - for list the objects\n" +
                "- GET (path ‘/{id}’) - for get an object with id = {id}\n" +
                "- POST (path ‘’ or ‘/‘) - for save (or for update ) an object. With the JSON (object) in the request body\n" +
                "- DELETE (path ‘/{id}’) - for delete an object with id = {id}\n" +
                "\n" +
                "Special endpoint for ‘/lectures’ :\n" +
                "- ‘/days/{dayOfWeekNumber}/students/{studentId}’\n" +
                "Where:\n" +
                " {dayOfWeekNumber} - it’s a number of week day (1-MONDAY, 2-TUESDAY etc.)\n" +
                " {studentId} - it’s student’s id (in test DB - from 1 to 10)\n" +
                "This request returns the JSON with the student schedule for the specified day";
    }

}
