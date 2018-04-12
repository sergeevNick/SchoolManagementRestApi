package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.Student;

import java.util.Set;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByStudentId(Integer id);
    Set<Student> findStudentsByStudentGradeGradeId(Integer gradeId);
}
