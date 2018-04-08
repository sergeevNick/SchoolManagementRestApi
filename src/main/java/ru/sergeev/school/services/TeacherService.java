package ru.sergeev.school.services;

import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Teacher;

import java.sql.Date;

public interface TeacherService {
    Iterable<Teacher> listAllTeachers();
    Teacher getTeacherById(Integer id);
    Teacher getTeacherByName(Name name);
    Teacher getTeacherByNameId(Integer nameId);

    void deleteTeacherById(Integer id);
    void deleteTeacherByName(Name name);

    Teacher saveTeacher(String firsName, String secondName, String lastName, String email, String address, Date birthDate);
    Teacher saveTeacher(Name name, OtherInfo info);
}
