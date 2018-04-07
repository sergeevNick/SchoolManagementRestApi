package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Day;
import ru.sergeev.school.entities.Schedule;

import java.util.Set;

public interface DayRepository extends CrudRepository<Day, Integer> {
    Day findDayByDayId(Integer id);
    Day findDayByDayName(String name);
    Day findDayBySchedules(Set<Schedule> schedules);
}

