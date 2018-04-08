package ru.sergeev.school.services;

import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Student;

import java.sql.Date;

public interface StudentService {
    Iterable<Student> listAllStudents();
    Iterable<Student> getStudentsByGradeId(Integer gradeId);
    Student getStudentById(Integer id);
    Student getStudentByName(Name name);
    Student getStudentByNameId(Integer nameId);

    void deleteStudent(Integer id);
    void deleteStudent(Name name);

    Student saveStudent(String firsName, String secondName, String lastName, String email, String address, Date birthDate);
    Student saveStudent(Name name, OtherInfo info);
}
