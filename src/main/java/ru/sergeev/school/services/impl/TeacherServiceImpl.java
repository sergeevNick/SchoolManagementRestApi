package ru.sergeev.school.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Teacher;
import ru.sergeev.school.repository.NameRepository;
import ru.sergeev.school.repository.OtherInfoRepository;
import ru.sergeev.school.repository.TeacherRepository;
import ru.sergeev.school.services.TeacherService;

import java.sql.Date;

@Transactional
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final NameRepository nameRepository;
    private final OtherInfoRepository otherInfoRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,
                              NameRepository nameRepository,
                              OtherInfoRepository otherInfoRepository) {
        this.teacherRepository = teacherRepository;
        this.nameRepository = nameRepository;
        this.otherInfoRepository = otherInfoRepository;
    }

    @Override
    public Iterable<Teacher> listAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteTeacherByTeacherId(id);
    }

    @Override
    public void deleteTeacherByName(Name name) {
        teacherRepository.deleteTeacherByName(name);
    }

    @Override
    public Teacher saveTeacher(String firsName, String secondName, String lastName, String email, String address, Date birthDate) {
        return teacherRepository.save(new Teacher(nameRepository.save(new Name(firsName, secondName, lastName)),
                otherInfoRepository.save(new OtherInfo(email, address, birthDate))));
    }

    @Override
    public Teacher saveTeacher(Name name, OtherInfo info) {
        return teacherRepository.save(new Teacher(nameRepository.save(name), otherInfoRepository.save(info)));
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findTeacherByTeacherId(id);
    }

    @Override
    public Teacher getTeacherByName(Name name) {
        return teacherRepository.findFirstByName(name);
    }

    @Override
    public Teacher getTeacherByNameId(Integer nameId) {
        return teacherRepository.findFirstByNameNameId(nameId);
    }
}
