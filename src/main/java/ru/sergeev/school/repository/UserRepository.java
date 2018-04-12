package ru.sergeev.school.repository;


import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}

