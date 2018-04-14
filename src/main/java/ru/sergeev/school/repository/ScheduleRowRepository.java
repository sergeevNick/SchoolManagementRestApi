package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.ScheduleRow;

public interface ScheduleRowRepository extends CrudRepository<ScheduleRow, Integer> {
}
