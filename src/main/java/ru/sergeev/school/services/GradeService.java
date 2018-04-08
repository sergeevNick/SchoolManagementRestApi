package ru.sergeev.school.services;

import ru.sergeev.school.entities.Grade;

public interface GradeService {
    Iterable<Grade> listAllGrades();
    Grade getGradeById(Integer id);

    void deleteGrade(Integer id);
    void deleteGrade(String number);

    Grade saveGrade(String number);
}
