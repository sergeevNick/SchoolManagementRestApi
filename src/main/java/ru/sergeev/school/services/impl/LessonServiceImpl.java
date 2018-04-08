package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.Lesson;
import ru.sergeev.school.repository.LessonRepository;
import ru.sergeev.school.services.LessonService;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Iterable<Lesson> listAllLessons() {
        return lessonRepository.findAllByOrderByLessonIdAsc();
    }

    @Override
    public Lesson getLessonById(Integer id) {
        return lessonRepository.findLessonByLessonId(id);
    }
}
