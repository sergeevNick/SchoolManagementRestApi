package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "CLASSES")
public class Grade {
//done

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLASS_ID")
    private Integer gradeId;

    @Column(name = "NUMBER")
    private String number;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "studentGrade")
    @OrderBy("name ASC")
    private Set<Student> students;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Schedule.class, mappedBy = "scheduleGrade")
    private Set<Schedule> schedules;


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
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

    public Integer getGradeId() {

        return gradeId;
    }

    public String getNumber() {
        return number;
    }

    public Grade() {
    }

    public Grade(String number) {
        this.number = number;
    }
}
