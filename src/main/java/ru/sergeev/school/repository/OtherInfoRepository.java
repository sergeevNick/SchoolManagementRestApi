package ru.sergeev.school.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sergeev.school.entities.OtherInfo;
import ru.sergeev.school.entities.Student;
import ru.sergeev.school.entities.Teacher;

public interface OtherInfoRepository extends CrudRepository<OtherInfo, Integer> {
}
