package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.repository.MarkRepository;
import ru.sergeev.school.repository.StudentRepository;
import ru.sergeev.school.repository.SubjectRepository;
import ru.sergeev.school.services.MarkService;

import java.sql.Date;


@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository,
                           StudentRepository studentRepository,
                           SubjectRepository subjectRepository) {
        this.markRepository = markRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Iterable<Mark> listAllMarks() {
        return markRepository.findAllByOrderByDateAsc();
    }

    @Override
    public Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
        return markRepository.findMarksByStudentStudentIdAndSubjectSubjectId(studentId, subjectId);
    }

    @Override
    public Iterable<Mark> getMarksByStudentIdAndSubjectName(Integer studentId, String subjectName) {
        return markRepository.findMarksByStudentStudentIdAndSubjectName(studentId, subjectName);
    }

    @Transactional
    @Override
    public void deleteMarkById(Integer id) {
        markRepository.deleteMarkByMarkId(id);
    }

    @Override
    public Mark saveMark(Integer value, Integer studentId, Integer subjectId) {
        Mark mark = new Mark(value);
        mark.setDate(new Date(new java.util.Date().getTime()));
        mark.setStudent(studentRepository.findByStudentId(studentId));
        mark.setSubject(subjectRepository.findSubjectBySubjectId(subjectId));
        return saveMark(mark);
    }

    @Override
    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark saveMark(Integer value, Date date) {
        return markRepository.save(new Mark(value, date));
    }
}
