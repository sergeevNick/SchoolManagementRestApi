package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "NAMES")
public class Name {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NAME_ID")
    private Integer nameId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "LAST_NAME")
    private String lastName;


    public Name(String firstName, String secondName, String lastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
    }

    @OneToOne(targetEntity = Student.class, mappedBy = "name", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(targetEntity = Teacher.class, mappedBy = "name", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Teacher teacher;

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getNameId() {
        return nameId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Name() {
    }
}
