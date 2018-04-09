package ru.sergeev.school.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.services.MarkService;

@RestController
@Api(value="mark", description="Operations pertaining to marks in school")
public class MarkRest {
    private final MarkService markService;

    @Autowired
    public MarkRest(MarkService markService) {
        this.markService = markService;
    }

    @ApiOperation(value = "Provides all marks in database")
    @RequestMapping(value = "/marks", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllMarks() {
        return ResponseEntity.ok(markService.listAllMarks());
    }

    @ApiOperation(value = "Provides all marks for a particular subject from the student")
    @RequestMapping(value = "/marks/students/{studentId}/subjects/{subjectId}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Mark>> getMarksByStudentIdAndSubjectId(@PathVariable(value = "subjectId") Integer subjectId,
                                                                          @PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(markService.getMarksByStudentIdAndSubjectId(studentId, subjectId));
    }

    @ApiOperation(value = "Add new mark for a particular subject from the student")
    @RequestMapping(value = "/marks/students/{studentId}/subjects/{subjectId}", method = RequestMethod.POST)
    public ResponseEntity<Mark> addMark(@RequestBody Mark mark, @PathVariable(value = "subjectId") Integer subjectId,
                                        @PathVariable(value = "studentId") Integer studentId) {
        return ResponseEntity.ok(markService.saveMark(mark.getValue(), studentId, subjectId));
    }

    @ApiOperation(value = "Deletes a certain mark by mark id")
    @RequestMapping(value = "/marks/{markId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMark(@PathVariable(value = "markId") Integer markId) {
        markService.deleteMarkById(markId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
