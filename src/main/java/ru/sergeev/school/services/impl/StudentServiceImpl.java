package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.repository.NameRepository;
import ru.sergeev.school.repository.OtherInfoRepository;
import ru.sergeev.school.repository.StudentRepository;
import ru.sergeev.school.services.StudentService;

import java.sql.Date;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> getStudentsByGradeId(Integer gradeId) {
        return studentRepository.findStudentsByStudentGradeGradeId(gradeId);
    }
}
