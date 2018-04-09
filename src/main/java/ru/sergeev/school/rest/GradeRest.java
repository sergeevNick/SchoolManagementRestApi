package ru.sergeev.school.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.services.GradeService;

@RestController
@RequestMapping("grades")
@Api(value="grade", description="Operations pertaining to grades in school")
public class GradeRest {

    private final GradeService gradeService;

    @Autowired
    public GradeRest(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @ApiOperation(value = "Provides all grades")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Grade>> getAllGrades() {
        return ResponseEntity.ok(gradeService.listAllGrades());
    }

    @ApiOperation(value = "Provides a grade by grade id")
    @RequestMapping(value = "/{gradeId}", method = RequestMethod.GET)
    public ResponseEntity<Grade> getGradeById(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(gradeService.getGradeById(gradeId));
    }
}
