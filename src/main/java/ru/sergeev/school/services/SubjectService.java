package ru.sergeev.school.services;

import ru.sergeev.school.entities.Subject;

public interface SubjectService {
    Iterable<Subject> getSubjectsByGradeId(Integer gradeId);
}
