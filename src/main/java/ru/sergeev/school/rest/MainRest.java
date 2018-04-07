package ru.sergeev.school.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.service.MainService;

@RestController
public class MainRest {

    private final MainService service;

    @Autowired
    public MainRest(MainService service) {
        this.service = service;
    }

    /*@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity handle() {
        System.out.println("In options request");
        return new ResponseEntity(HttpStatus.OK);
    }*/

    @RequestMapping(value = "students", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        return ResponseEntity.ok(service.listAllStudents());
    }

    @RequestMapping(value = "students/{studentId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getStudentById(@PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(service.getStudentById(studentId));
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllTeachers() {
        return ResponseEntity.ok(service.listAllTeachers());
    }

    @RequestMapping(value = "/teachers/{teacherId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTeacherById(@PathVariable(value = "teacherId") Integer teacherId) {
        return ResponseEntity.ok(service.getTeacherById(teacherId));
    }

    @RequestMapping(value = "/days", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllDays() {
        return ResponseEntity.ok(service.listAllDays());
    }

    @RequestMapping(value = "/lessons", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllLessons() {
        return ResponseEntity.ok(service.listAllLessons());
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ResponseEntity<Object> getAllLogins(){
//        return ResponseEntity.ok(service.listAllLogins());
//    }

    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllMarks() {
        return ResponseEntity.ok(service.listAllMarks());
    }

    @RequestMapping(value = "/marks/{markId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMark(@PathVariable(value = "markId") Integer markId) {
        service.deleteMarkById(markId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/marks/students/{studentId}/subjects/{subjectId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Mark>> getMarksByStudentIdAndSubjectId(@PathVariable(value = "subjectId") Integer subjectId,
                                                                          @PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(service.getMarksByStudentIdAndSubjectId(studentId, subjectId));
    }

    @RequestMapping(value = "/marks/students/{studentId}/subjects/{subjectId}", method = RequestMethod.POST)
    public ResponseEntity<Mark> addMark(@RequestBody Mark mark, @PathVariable(value = "subjectId") Integer subjectId,
                                        @PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(service.saveMark(mark.getValue(), studentId, subjectId));
    }
}
