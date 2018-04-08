package ru.sergeev.school.services;

import ru.sergeev.school.entities.Mark;

import java.sql.Date;

public interface MarkService {
    Iterable<Mark> listAllMarks();
    Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
    Iterable<Mark> getMarksByStudentIdAndSubjectName(Integer studentId, String subjectName);

    void deleteMarkById(Integer id);

    Mark saveMark(Integer value, Integer studentId, Integer subjectId );
    Mark saveMark(Mark mark);
    Mark saveMark(Integer value, Date date);
}
