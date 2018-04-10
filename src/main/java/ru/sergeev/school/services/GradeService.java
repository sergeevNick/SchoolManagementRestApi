package ru.sergeev.school.services;

import ru.sergeev.school.entities.Grade;

public interface GradeService {
    Iterable<Grade> listAllGrades();
    Grade getGradeById(Integer id);

    void deleteGradeById(Integer id);
    void deleteGradeByNumber(String number);

    Grade saveGrade(String number);
}
