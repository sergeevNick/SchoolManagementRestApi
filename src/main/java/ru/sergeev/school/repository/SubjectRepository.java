package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.entities.Subject;

import java.util.Set;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Subject findSubjectBySubjectId(Integer id);
    Subject findSubjectByName(String name);
    Subject findSubjectByRoom(Integer room);
    Set<Subject> findSubjectsByRows(Set<ScheduleRow> rows);
}
