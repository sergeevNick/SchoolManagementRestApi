package ru.sergeev.school.services;

import ru.sergeev.school.entities.User;

public interface UserService {
    Iterable<User> getStudentsByGradeId(Integer gradeId);
}
