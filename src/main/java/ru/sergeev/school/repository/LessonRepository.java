package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Lesson;
import ru.sergeev.school.entities.ScheduleRow;

import java.util.Set;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
}
