package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.entities.Teacher;

import java.util.Set;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Teacher findTeacherByTeacherId(Integer id);
    Teacher findFirstByName(Name name);
    Teacher findFirstByNameNameId(Integer nameId);

    void deleteTeacherByName(Name name);
    void deleteTeacherByTeacherId(Integer id);
}
