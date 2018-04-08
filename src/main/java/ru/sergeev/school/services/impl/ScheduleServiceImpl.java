package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.repository.ScheduleRepository;
import ru.sergeev.school.services.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Iterable<Schedule> listAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        return scheduleRepository.findScheduleByScheduleId(id);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGrade(Grade grade) {
        return scheduleRepository.findSchedulesByScheduleGrade(grade);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGradeId(Integer gradeId) {
        return scheduleRepository.findSchedulesByScheduleGradeGradeId(gradeId);
    }

    @Override
    public Iterable<Schedule> getSchedulesByGradeNumber(String gradeNumber) {
        return scheduleRepository.findSchedulesByScheduleGradeNumber(gradeNumber);
    }

    @Override
    public Schedule getSchedulesByGradeIdAndDayId(Integer gradeId, Integer dayId) {
        return scheduleRepository.findScheduleByScheduleGradeGradeIdAndDayDayId(gradeId, dayId);
    }

    @Override
    public Schedule getSchedulesByGradeIdAndDayName(Integer gradeId, String dayName) {
        return scheduleRepository.findScheduleByScheduleGradeGradeIdAndDayDayName(gradeId, dayName);
    }
}
