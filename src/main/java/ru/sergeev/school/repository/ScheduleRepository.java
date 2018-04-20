package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Schedule;

import java.util.Set;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    Set<Schedule> findSchedulesByGradeGradeId(Integer gradeId);
}
