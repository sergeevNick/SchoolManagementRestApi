package ru.sergeev.school.services;

import ru.sergeev.school.entities.Mark;

import java.sql.Date;

public interface MarkService {
    Iterable<Mark> listAllMarks();
    Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId);

    void deleteMarkById(Integer id);

    Mark saveMark(Integer value, Integer studentId, Integer subjectId );
}
