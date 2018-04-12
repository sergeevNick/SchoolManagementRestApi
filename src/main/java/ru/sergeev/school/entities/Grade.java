package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "CLASSES")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLASS_ID")
    private Integer gradeId;

    @Column(name = "NUMBER")
    private String number;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "studentGrade")
    @OrderBy("name ASC")
    private Set<Student> students;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Schedule.class, mappedBy = "scheduleGrade")
    private Set<Schedule> schedules;

    public Grade(String number) {
        this.number = number;
    }

    public Grade() {
    }

    public Set<Student> getStudents() {
        return students;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public String getNumber() {
        return number;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
