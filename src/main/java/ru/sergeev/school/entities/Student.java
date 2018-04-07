package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STUDENT_ID")
    private Integer studentId;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "USER_ID")
    private User login;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Name.class)
    @JoinColumn(name = "NAME_ID")
    @OrderBy("secondName ASC")
    private Name name;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = OtherInfo.class)
    @JoinColumn(name = "OTHER_INFO_ID")
    private OtherInfo otherInfo;

    @OneToMany(targetEntity = Mark.class, mappedBy = "student", fetch = FetchType.LAZY)
    private Set<Mark> marks;

    @ManyToOne(targetEntity = Grade.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLASS_ID")
    private Grade studentGrade;

    public void setStudentGrade(Grade studentGrade) {
        this.studentGrade = studentGrade;
    }

    public Set<Mark> getMarks() {
        return marks;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

//    public User getLogin() {
//        return login;
//    }

    public void setLogin(User login) {
        this.login = login;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Student() {
    }

    public Student(Name name, OtherInfo otherInfo) {
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
