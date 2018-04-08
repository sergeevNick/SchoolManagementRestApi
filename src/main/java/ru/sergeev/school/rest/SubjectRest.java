package ru.sergeev.school.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.services.SubjectService;

@RestController
public class SubjectRest {
    private final SubjectService subjectService;

    @Autowired
    public SubjectRest(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/grades/{gradeId}/subjects", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Subject>> getSubjectsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(subjectService.getSubjectsByGradeId(gradeId));
    }
}
