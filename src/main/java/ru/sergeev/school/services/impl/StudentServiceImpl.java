package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private final NameRepository nameRepository;
    private final OtherInfoRepository otherInfoRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,
                              NameRepository nameRepository,
                              OtherInfoRepository otherInfoRepository) {
        this.studentRepository = studentRepository;
        this.nameRepository = nameRepository;
        this.otherInfoRepository = otherInfoRepository;
    }

    public Iterable<Student> listAllStudents() {
        return studentRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Iterable<Student> getStudentsByGradeId(Integer gradeId) {
        return studentRepository.findStudentsByStudentGradeGradeId(gradeId);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findByStudentId(id);
    }

    @Override
    public Student getStudentByName(Name name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student getStudentByNameId(Integer nameId) {
        return studentRepository.findStudentByNameNameId(nameId);
    }

    public void deleteStudent(Integer id) {
        studentRepository.delete(id);
    }

    public void deleteStudent(Name name) {
        studentRepository.deleteByName(name);
    }

    public Student saveStudent(String firsName, String secondName, String lastName, String email, String address, Date birthDate) {
        return studentRepository.save(new Student(nameRepository.save(new Name(firsName, secondName, lastName)),
                otherInfoRepository.save(new OtherInfo(email, address, birthDate))));
    }

    public Student saveStudent(Name name, OtherInfo info) {
        return studentRepository.save(new Student(nameRepository.save(name), otherInfoRepository.save(info)));
    }


}
