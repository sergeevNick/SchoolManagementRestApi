package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Day;
import ru.sergeev.school.entities.Schedule;

import java.util.Set;

public interface DayRepository extends CrudRepository<Day, Integer> {
}

