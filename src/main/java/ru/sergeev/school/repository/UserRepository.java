package ru.sergeev.school.repository;


import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.User;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByUserId(Integer id);
    Set<User> findUsersByRole(String role);
    Set<User> findUsersByRoleAndGradeGradeId(String role, Integer gradeId);

}

