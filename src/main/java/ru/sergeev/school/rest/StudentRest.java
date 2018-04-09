package ru.sergeev.school.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.services.StudentService;

@RestController
@Api(value="students", description="Operations pertaining to students in school")
public class StudentRest {
    private final StudentService studentService;

    @Autowired
    public StudentRest(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "Provides a list of students by grade id")
    @RequestMapping(value = "/grades/{gradeId}/students", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(studentService.getStudentsByGradeId(gradeId));
    }

    @ApiOperation(value = "Provides a list of all students in database")
    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(studentService.listAllStudents());
    }

    @ApiOperation(value = "Provides a certain student by student id")
    @RequestMapping(value = "students/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getStudentById(@PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }


}
