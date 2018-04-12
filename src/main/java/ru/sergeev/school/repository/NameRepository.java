package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Name;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.entities.Teacher;

public interface NameRepository extends CrudRepository<Name, Integer> {
}
