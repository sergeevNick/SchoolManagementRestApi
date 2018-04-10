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

@Transactional
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository, ScheduleRepository scheduleRepository) {
        this.subjectRepository = subjectRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Iterable<Subject> listAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Iterable<Subject> getSubjectsByGradeId(Integer gradeId) {
        Set<Subject> subjectSet = new HashSet<>();
        for (Schedule schedule : scheduleRepository.findSchedulesByScheduleGradeGradeId(gradeId)) {
            for (ScheduleRow row : schedule.getRows()) {
                subjectSet.add(row.getSubject());
            }
        }
        return subjectSet;
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectRepository.findSubjectBySubjectId(id);
    }

    @Override
    public Subject getSubjectByName(String subjectName) {
        return subjectRepository.findSubjectByName(subjectName);
    }
}
