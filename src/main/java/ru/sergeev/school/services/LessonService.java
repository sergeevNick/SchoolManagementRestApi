package ru.sergeev.school.services;

import ru.sergeev.school.entities.Lesson;

public interface LessonService {
    Iterable<Lesson> listAllLessons();
    Lesson getLessonById(Integer id);
}
