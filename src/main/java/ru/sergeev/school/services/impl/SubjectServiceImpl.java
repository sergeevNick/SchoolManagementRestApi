package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Schedule;
import ru.sergeev.school.entities.ScheduleRow;
import ru.sergeev.school.entities.Subject;
import ru.sergeev.school.repository.ScheduleRepository;
import ru.sergeev.school.repository.SubjectRepository;
import ru.sergeev.school.services.SubjectService;

import java.util.HashSet;
import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public SubjectServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Iterable<Subject> getSubjectsByGradeId(Integer gradeId) {
        Set<Subject> subjectSet = new HashSet<>();
        if (scheduleRepository.findSchedulesByGradeGradeId(gradeId) != null) {
            for (Schedule schedule : scheduleRepository.findSchedulesByGradeGradeId(gradeId)) {
                for (ScheduleRow row : schedule.getRows()) {
                    subjectSet.add(row.getSubject());
                }
            }
        }
        return subjectSet;
    }
}
