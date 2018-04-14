package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Mark;
import java.util.Set;

public interface MarkRepository extends CrudRepository<Mark, Integer> {
    Set<Mark> findMarksByStudentUserIdAndSubjectSubjectId(Integer studentId, Integer subjectId);

    void deleteMarkByMarkId(Integer id);
}
