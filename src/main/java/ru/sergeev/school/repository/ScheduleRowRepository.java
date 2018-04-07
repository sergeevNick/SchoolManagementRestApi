package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.entities.Teacher;

import java.util.Set;

public interface ScheduleRowRepository extends CrudRepository<ScheduleRow, Integer> {
    ScheduleRow findScheduleRowByScheduleRowId(Integer id);
    Set<ScheduleRow> findScheduleRowsBySchedule(Schedule schedule);
    Set<ScheduleRow> findScheduleRowsByScheduleScheduleId(Integer scheduleId);

    Set<ScheduleRow> findScheduleRowsByTeacher(Teacher teacher);
    Set<ScheduleRow> findScheduleRowsByTeacherTeacherId(Integer teacherId);

    Set<ScheduleRow> findScheduleRowsBySubject(Subject subject);
    Set<ScheduleRow> findScheduleRowsBySubjectSubjectId(Integer subjectId);
}
