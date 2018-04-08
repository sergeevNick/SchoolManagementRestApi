package ru.sergeev.school.services;

import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Schedule;

public interface ScheduleService {
    Iterable<Schedule> listAllSchedules();
    Schedule getScheduleById(Integer id);
    Iterable<Schedule> getSchedulesByGrade(Grade grade);
    Iterable<Schedule> getSchedulesByGradeId(Integer gradeId);
    Iterable<Schedule> getSchedulesByGradeNumber(String gradeNumber);
    Schedule getSchedulesByGradeIdAndDayId(Integer gradeId, Integer dayId);
    Schedule getSchedulesByGradeIdAndDayName(Integer gradeId, String dayName);
}
