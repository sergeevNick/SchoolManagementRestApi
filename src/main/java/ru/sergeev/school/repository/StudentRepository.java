package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.Student;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Iterable<Student> findAllByOrderByNameAsc();

    Student findByStudentId(Integer id);
    Student findByName(Name name);
    Student findStudentByNameNameId(Integer nameId);

    Set<Student> findStudentsByStudentGrade(Grade studentGrade);
    Set<Student> findStudentsByStudentGradeGradeId(Integer gradeId);

    void deleteStudentByName(Name name);
    void deleteStudentByStudentId(Integer id);
}
