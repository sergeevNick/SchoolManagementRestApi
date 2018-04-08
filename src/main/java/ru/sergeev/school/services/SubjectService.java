package ru.sergeev.school.services;

import ru.sergeev.school.entities.Subject;

public interface SubjectService {
    Iterable<Subject> listAllSubjects();
    Iterable<Subject> getSubjectsByGradeId(Integer gradeId);
    Subject getSubjectById(Integer id);
    Subject getSubjectByName(String subjectName);
}
