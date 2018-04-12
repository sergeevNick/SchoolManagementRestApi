package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.entities.Subject;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

public interface MarkRepository extends CrudRepository<Mark, Integer> {
    Mark findMarkByMarkId(Integer id);
    Set<Mark> findMarksByStudentStudentIdAndSubjectSubjectId(Integer studentId, Integer subjectId);

    void deleteMarkByMarkId(Integer id);
}
