package ru.sergeev.school.services;

import ru.sergeev.school.entities.Schedule;

public interface ScheduleService {
    Iterable<Schedule> getSchedulesByGradeId(Integer gradeId);
}
