package ru.sergeev.school.services;

import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Student;

import java.sql.Date;

public interface StudentService {
    Iterable<Student> getStudentsByGradeId(Integer gradeId);
}
