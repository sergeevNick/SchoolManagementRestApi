package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.Grade;

public interface GradeRepository extends CrudRepository<Grade, Integer> {
    Iterable<Grade> findAllByOrderByNumberAsc();
}
