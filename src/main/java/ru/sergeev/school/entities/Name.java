package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "NAMES")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NAME_ID")
    private Integer nameId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToOne(targetEntity = Student.class, mappedBy = "name", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(targetEntity = Teacher.class, mappedBy = "name", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Teacher teacher;

    public Name(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    public Name() {
    }

    public Integer getNameId() {
        return nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
