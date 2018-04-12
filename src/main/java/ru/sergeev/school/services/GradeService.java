package ru.sergeev.school.services;

import ru.sergeev.school.entities.Grade;

public interface GradeService {
    Iterable<Grade> listAllGrades();
}
