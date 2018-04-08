package ru.sergeev.school.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.services.StudentService;

@RestController
public class StudentRest {
    private final StudentService studentService;

    @Autowired
    public StudentRest(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/grades/{gradeId}/students", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentsByGradeId(@PathVariable(value = "gradeId") Integer gradeId) {
        return ResponseEntity.ok(studentService.getStudentsByGradeId(gradeId));
    }

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(studentService.listAllStudents());
    }

    @RequestMapping(value = "students/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getStudentById(@PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }


}
