package ru.sergeev.school.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.*;
import ru.sergeev.school.repository.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class MainServiceImpl implements MainService {

    private final GradeRepository gradeRepository;
    private final DayRepository dayRepository;
    private final LessonRepository lessonRepository;
    private final MarkRepository markRepository;
    private final NameRepository nameRepository;
    private final OtherInfoRepository otherInfoRepository;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleRowRepository scheduleRowRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final UserRepository userRepository;

    @Autowired
    public MainServiceImpl(GradeRepository gradeRepository,
                           DayRepository dayRepository,
                           LessonRepository lessonRepository,
                           MarkRepository markRepository,
                           NameRepository nameRepository,
                           OtherInfoRepository otherInfoRepository,
                           ScheduleRepository scheduleRepository,
                           ScheduleRowRepository scheduleRowRepository,
                           StudentRepository studentRepository,
                           SubjectRepository subjectRepository,
                           TeacherRepository teacherRepository,
                           UserRepository userRepository) {
        this.gradeRepository = gradeRepository;
        this.dayRepository = dayRepository;
        this.lessonRepository = lessonRepository;
        this.markRepository = markRepository;
        this.nameRepository = nameRepository;
        this.otherInfoRepository = otherInfoRepository;
        this.scheduleRepository = scheduleRepository;
        this.scheduleRowRepository = scheduleRowRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Student> listAllStudents() {
        return studentRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Iterable<Student> getStudentsByGradeId(Integer gradeId) {
        return studentRepository.findStudentsByStudentGradeGradeId(gradeId);
    }

    public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }

    public void deleteStudent(Name name) {
        studentRepository.deleteByName(name);
    }

    public Student saveStudent(String firsName, String secondName, String lastName, String email, String address, Date birthDate) {
        return studentRepository.save(new Student(nameRepository.save(new Name(firsName, secondName, lastName)),
                otherInfoRepository.save(new OtherInfo(email, address, birthDate))));
    }

    public Student saveStudent(Name name, OtherInfo info) {
        return studentRepository.save(new Student(nameRepository.save(name), otherInfoRepository.save(info)));
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findByStudentId(id);
    }

    @Override
    public Student getStudentByName(Name name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student getStudentByNameId(Integer nameId) {
        return studentRepository.findStudentByNameNameId(nameId);
    }

    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    public void deleteTeacher(Integer id) {
        teacherRepository.delete(id);
    }

    public void deleteTeacher(Name name) {

    }

    public Teacher saveTeacher(String firsName, String secondName, String lastName, String email, String address, Date birthDate) {
        return teacherRepository.save(new Teacher(nameRepository.save(new Name(firsName, secondName, lastName)),
                otherInfoRepository.save(new OtherInfo(email, address, birthDate))));
    }

    public Teacher saveTeacher(Name name, OtherInfo info) {
        return teacherRepository.save(new Teacher(nameRepository.save(name), otherInfoRepository.save(info)));
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findTeacherByTeacherId(id);
    }

    @Override
    public Teacher getTeacherByName(Name name) {
        return teacherRepository.findFirstByName(name);
    }

    @Override
    public Teacher getTeacherByNameId(Integer nameId) {
        return teacherRepository.findFirstByNameNameId(nameId);
    }

    public Iterable<Grade> listAllGrades() {
        return gradeRepository.findAllByOrderByNumberAsc();
    }

    public void deleteGrade(Integer id) {
        gradeRepository.delete(id);
    }

    public void deleteGrade(String number) {
        gradeRepository.deleteGradeByNumber(number);
    }

    @Override
    public Grade saveGrade(String number) {
        return gradeRepository.save(new Grade(number));
    }

    @Override
    public Grade getGradeById(Integer id) {
        return gradeRepository.findGradeByGradeId(id);
    }

    public Iterable<Lesson> listAllLessons() {
        return lessonRepository.findAllByOrderByLessonIdAsc();
    }

    public Lesson findLessonById(Integer id) {
        return lessonRepository.findLessonByLessonId(id);
    }

    @Override
    public Iterable<Day> listAllDays() {
        return dayRepository.findAll();
    }

    @Override
    public Iterable<User> listAllLogins() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<Schedule> listAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        return scheduleRepository.findScheduleByScheduleId(id);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGrade(Grade grade) {
        return scheduleRepository.findSchedulesByScheduleGrade(grade);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGradeId(Integer gradeId) {
        return scheduleRepository.findSchedulesByScheduleGradeGradeId(gradeId);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGradeNumber(String gradeNumber) {
        return scheduleRepository.findSchedulesByScheduleGradeNumber(gradeNumber);
    }

    @Override
    public Schedule getSchedulesByGradeIdAndDayId(Integer gradeId, Integer dayId) {
        return scheduleRepository.findScheduleByScheduleGradeGradeIdAndDayDayId(gradeId, dayId);
    }

    @Override
    public Schedule getSchedulesByGradeIdAndDayName(Integer gradeId, String dayName) {
        return scheduleRepository.findScheduleByScheduleGradeGradeIdAndDayDayName(gradeId, dayName);
    }

    @Override
    public Iterable<ScheduleRow> listAllScheduleRows() {
        return scheduleRowRepository.findAll();
    }

    @Override
    public ScheduleRow getScheduleRowById(Integer id) {
        return scheduleRowRepository.findScheduleRowByScheduleRowId(id);
    }

    @Override
    public Iterable<ScheduleRow> getScheduleRowsByScheduleId(Integer scheduleId) {
        return scheduleRowRepository.findScheduleRowsByScheduleScheduleId(scheduleId);
    }

    @Override
    public Iterable<Subject> listAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Iterable<Subject> getSubjectsByGradeId(Integer gradeId) {
        Set<Subject> subjectSet = new HashSet<>();
        for (Schedule schedule : getSchedulesByGradeId(gradeId)) {
            for (ScheduleRow row : schedule.getRows()) {
                subjectSet.add(row.getSubject());
            }
        }
        return subjectSet;
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectRepository.findSubjectBySubjectId(id);
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        return subjectRepository.findSubjectByName(subjectName);
    }

    @Override
    public Iterable<Mark> listAllMarks() {
        return markRepository.findAllByOrderByDateAsc();
    }

    @Override
    public Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
        return markRepository.findMarksByStudentStudentIdAndSubjectSubjectId(studentId, subjectId);
    }

    @Override
    public Iterable<Mark> getMarksByStudentIdAndSubjectName(Integer studentId, String subjectName) {
        return markRepository.findMarksByStudentStudentIdAndSubjectName(studentId, subjectName);
    }

    @Override
    public void deleteMarkById(Integer id) {
        markRepository.delete(id);
    }

    @Override
    public Mark saveMark(Integer value, Integer studentId, Integer subjectId) {
        Mark mark = new Mark(value);
        mark.setDate(new Date(new java.util.Date().getTime()));
        mark.setStudent(getStudentById(studentId));
        mark.setSubject(getSubjectById(subjectId));
        return saveMark(mark);
    }

    @Override
    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark saveMark(Integer value, Date date) {
        return markRepository.save(new Mark(value, date));
    }
}
