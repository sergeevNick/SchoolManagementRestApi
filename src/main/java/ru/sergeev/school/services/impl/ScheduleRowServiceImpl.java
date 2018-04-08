package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.repository.ScheduleRowRepository;
import ru.sergeev.school.services.ScheduleRowService;

@Service
public class ScheduleRowServiceImpl implements ScheduleRowService {
    private final ScheduleRowRepository scheduleRowRepository;

    @Autowired
    public ScheduleRowServiceImpl(ScheduleRowRepository scheduleRowRepository) {
        this.scheduleRowRepository = scheduleRowRepository;
    }

    @Override
    public Iterable<ScheduleRow> listAllScheduleRows() {
        return scheduleRowRepository.findAll();
    }


    @Override
    public ScheduleRow getScheduleRowById(Integer id) {
        return scheduleRowRepository.findScheduleRowByScheduleRowId(id);
    }

    @Override
    public Iterable<ScheduleRow> getScheduleRowsByScheduleId(Integer scheduleId) {
        return scheduleRowRepository.findScheduleRowsByScheduleScheduleId(scheduleId);
    }
}
