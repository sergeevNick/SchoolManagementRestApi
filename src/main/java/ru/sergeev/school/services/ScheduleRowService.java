package ru.sergeev.school.services;

import ru.sergeev.school.entities.ScheduleRow;

public interface ScheduleRowService {
    Iterable<ScheduleRow> listAllScheduleRows();
    ScheduleRow getScheduleRowById(Integer id);
    Iterable<ScheduleRow> getScheduleRowsByScheduleId(Integer scheduleId);
}
