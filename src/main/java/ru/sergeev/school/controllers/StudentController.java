package ru.sergeev.school.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.User;
import ru.sergeev.school.services.UserService;

@RestController
@Api(value="students", description="Operations pertaining to students in school")
public class StudentController {
    private final UserService userService;

    @Autowired
    public StudentController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Provides a list of students by grade id")
    @RequestMapping(value = "/grades/{gradeId}/students", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getStudentsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(userService.getStudentsByGradeId(gradeId));
    }
}
