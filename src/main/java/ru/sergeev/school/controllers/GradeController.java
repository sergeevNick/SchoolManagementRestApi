package ru.sergeev.school.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.services.GradeService;

@RestController
@RequestMapping("grades")
@Api(value="grade", description="Operations pertaining to grades in school")
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @ApiOperation(value = "Provides all grades")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Grade>> getAllGrades() {
        return ResponseEntity.ok(gradeService.listAllGrades());
    }
}
