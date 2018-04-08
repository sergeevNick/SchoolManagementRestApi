package ru.sergeev.school.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.services.ScheduleService;

@RestController
public class ScheduleRest {
    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleRest(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping(value = "/grades/{gradeId}/schedule", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Schedule>> getScheduleByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(scheduleService.getSchedulesByGradeId(gradeId));
    }
}
