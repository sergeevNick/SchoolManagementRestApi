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
    public Iterable<Schedule> getSchedulesByGradeId(Integer gradeId) {
        return scheduleRepository.findSchedulesByScheduleGradeGradeId(gradeId);
    }
}
