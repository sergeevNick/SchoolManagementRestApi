package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Day;
import ru.sergeev.school.entities.Schedule;

import java.util.Set;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    Schedule findScheduleByScheduleId(Integer id);

    Schedule findScheduleByDay(Day day);
    Schedule findScheduleByDayDayId(Integer dayId);

    Set<Schedule> findSchedulesByScheduleGrade(Grade grade);
    Set<Schedule> findSchedulesByScheduleGradeGradeId(Integer gradeId);
    Set<Schedule> findSchedulesByScheduleGradeNumber(String gradeNumber);

    Schedule findScheduleByScheduleGradeGradeIdAndDayDayId(Integer gradeId, Integer dayId);
    Schedule findScheduleByScheduleGradeGradeIdAndDayDayName(Integer gradeId, String dayName);
}
