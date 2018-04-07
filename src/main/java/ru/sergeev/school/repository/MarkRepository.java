package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.entities.Subject;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

public interface MarkRepository extends CrudRepository<Mark, Integer> {
    Iterable<Mark>findAllByOrderByDateAsc();
    Mark findMarkByMarkId(Integer id);

    Set<Mark> findMarksByStudent(Student student);
    Set<Mark> findMarksByStudentStudentId(Integer studentId);

    Set<Mark> findMarksBySubject(Subject subject);
    Set<Mark> findMarksBySubjectName(String subjectName);
    Set<Mark> findMarksBySubjectSubjectId(Integer subjectId);

    Set<Mark> findMarksByStudentStudentIdAndSubjectSubjectId(Integer studentId, Integer subjectId);
    Set<Mark> findMarksByStudentStudentIdAndSubjectName(Integer studentId, String subjectName);
}
