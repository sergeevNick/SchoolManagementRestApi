package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Day;
import ru.sergeev.school.entities.Schedule;

import java.util.Set;

@Transactional
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    Set<Schedule> findSchedulesByGradeGradeId(Integer gradeId);
}
