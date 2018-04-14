package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Mark;
import ru.sergeev.school.repository.MarkRepository;
import ru.sergeev.school.repository.SubjectRepository;
import ru.sergeev.school.repository.UserRepository;
import ru.sergeev.school.services.MarkService;

import java.sql.Date;


@Service
public class MarkServiceImpl implements MarkService {
    private final MarkRepository markRepository;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    @Autowired
    public MarkServiceImpl(MarkRepository markRepository,
                           UserRepository userRepository,
                           SubjectRepository subjectRepository) {
        this.markRepository = markRepository;
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Iterable<Mark> listAllMarks() {
        return markRepository.findAll();
    }

    @Override
    public Iterable<Mark> getMarksByStudentIdAndSubjectId(Integer studentId, Integer subjectId) {
        return markRepository.findMarksByStudentUserIdAndSubjectSubjectId(studentId, subjectId);
    }

    @Transactional
    @Override
    public void deleteMarkById(Integer id) {
        markRepository.deleteMarkByMarkId(id);
    }

    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Mark saveMark(Integer value, Integer userId, Integer subjectId) {
        Mark mark = new Mark(value);
        mark.setDate(new Date(new java.util.Date().getTime()));
        mark.setStudent(userRepository.findUserByUserId(userId));
        mark.setSubject(subjectRepository.findSubjectBySubjectId(subjectId));
        return saveMark(mark);
    }
}
