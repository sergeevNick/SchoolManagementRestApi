package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeev.school.entities.Grade;
import ru.sergeev.school.repository.GradeRepository;
import ru.sergeev.school.services.GradeService;

@Service
public class GradeServiceImpl implements GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Iterable<Grade> listAllGrades() {
        return gradeRepository.findAllByOrderByNumberAsc();
    }

    @Override
    public Grade getGradeById(Integer id) {
        return gradeRepository.findGradeByGradeId(id);
    }

    @Override
    public void deleteGrade(Integer id) {
        gradeRepository.delete(id);
    }

    @Override
    public void deleteGrade(String number) {
        gradeRepository.deleteGradeByNumber(number);
    }

    @Override
    public Grade saveGrade(String number) {
        return gradeRepository.save(new Grade(number));
    }
}
