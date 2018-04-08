package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.Day;
import ru.sergeev.school.repository.DayRepository;
import ru.sergeev.school.services.DayService;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;

    @Autowired
    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public Iterable<Day> listAllDays() {
        return dayRepository.findAll();
    }
}
