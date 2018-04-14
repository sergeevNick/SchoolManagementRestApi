package ru.sergeev.school.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.services.SubjectService;

@RestController
@Api(value="subjects", description="Operations pertaining to subjects in school")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @ApiOperation(value = "Provides a list of subjects by grade id")
    @RequestMapping(value = "/grades/{gradeId}/subjects", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Subject>> getSubjectsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(subjectService.getSubjectsByGradeId(gradeId));
    }
}
