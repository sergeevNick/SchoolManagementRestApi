package ru.sergeev.school.service;


import ru.sergeev.school.entities.*;
import ru.sergeev.school.entities.Grade;

import java.sql.Date;

public interface MainService {

    Iterable<Student> listAllStudents();
    Iterable<Student> getStudentsByGradeId(Integer gradeId);
    void deleteStudent(Integer id);
    void deleteStudent(Name name);
    Student saveStudent(String firsName, String secondName, String lastName, String email, String address, Date birthDate);
    Student saveStudent(Name name, OtherInfo info);
    Student getStudentById(Integer id);
    Student getStudentByName(Name name);
    Student getStudentByNameId(Integer nameId);


    Iterable<Teacher> listAllTeachers();
    void deleteTeacher(Integer id);
    void deleteTeacher(Name name);
    Teacher saveTeacher(String firsName, String secondName, String lastName, String email, String address, Date birthDate);
    Teacher saveTeacher(Name name, OtherInfo info);
    Teacher getTeacherById(Integer id);
    Teacher getTeacherByName(Name name);
    Teacher getTeacherByNameId(Integer nameId);


    Iterable<Grade> listAllGrades();
    void deleteGrade(Integer id);
    void deleteGrade(String number);
    Grade saveGrade(String number);
    Grade getGradeById(Integer id);


    Iterable<Lesson> listAllLessons();
    Lesson findLessonById(Integer id);




    Iterable<Day> listAllDays();


    Iterable<User> listAllLogins();



    Iterable<Schedule> listAllSchedules();
    Schedule getScheduleById(Integer id);
    Iterable<Schedule> getSchedulesByGrade(Grade grade);
    Iterable<Schedule> getSchedulesByGradeId(Integer gradeId);
    Iterable<Schedule> getSchedulesByGradeNumber(String gradeNumber);
    Schedule getSchedulesByGradeIdAndDayId(Integer gradeId, Integer dayId);
    Schedule getSchedulesByGradeIdAndDayName(Integer gradeId, String dayName);


    Iterable<ScheduleRow> listAllScheduleRows();
    ScheduleRow getScheduleRowById(Integer id);
    Iterable<ScheduleRow> getScheduleRowsByScheduleId(Integer scheduleId);

    Iterable<Subject> listAllSubjects();
    Iterable<Subject> getSubjectsByGradeId(Integer gradeId);
    Subject getSubjectById(Integer id);
    Subject getSubjectByName(String subjectName);


    Iterable<Mark> listAllMarks();
    Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId);
    Iterable<Mark> getMarksByStudentIdAndSubjectName(Integer studentId, String subjectName);
    void deleteMarkById(Integer id);
    Mark saveMark(Integer value, Integer studentId, Integer subjectId );
    Mark saveMark(Mark mark);
    Mark saveMark(Integer value, Date date);

}
