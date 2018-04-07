package ru.sergeev.school.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.service.MainService;

@RestController
@RequestMapping("grades")
public class GradeRest {

    private final MainService service;

    @Autowired
    public GradeRest(MainService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Grade>> getAllGrades() {
        return ResponseEntity.ok(service.listAllGrades());
    }

    @RequestMapping(value = "/{gradeId}", method = RequestMethod.GET)
    public ResponseEntity<Grade> getGradeById(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(service.getGradeById(gradeId));
    }

    @RequestMapping(value = "/{gradeId}/students", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(service.getStudentsByGradeId(gradeId));
    }

    @RequestMapping(value = "/{gradeId}/subjects", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Subject>> getSubjectsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(service.getSubjectsByGradeId(gradeId));
    }

    @RequestMapping(value = "/{gradeId}/schedule", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Schedule>> getScheduleByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(service.getSchedulesByGradeId(gradeId));
    }
}
