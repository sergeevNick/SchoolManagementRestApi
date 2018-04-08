package ru.sergeev.school.services;

import ru.sergeev.school.entities.Day;

public interface DayService {
    Iterable<Day> listAllDays();
}
