package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.entities.Teacher;

import java.util.Set;

public interface ScheduleRowRepository extends CrudRepository<ScheduleRow, Integer> {
}
