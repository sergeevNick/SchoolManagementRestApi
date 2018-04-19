package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Mark;
import java.util.Set;

@Transactional
public interface MarkRepository extends CrudRepository<Mark, Integer> {
    Set<Mark> findMarksByStudentUserIdAndSubjectSubjectId(Integer studentId, Integer subjectId);

    void deleteMarkByMarkId(Integer id);
}
