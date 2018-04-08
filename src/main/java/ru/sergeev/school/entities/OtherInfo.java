package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "OTHER_INFO")
public class OtherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OTHER_INFO_ID")
    private Integer infoId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToOne(targetEntity = Student.class, mappedBy = "otherInfo", fetch = FetchType.LAZY)
    private Student student;

    @OneToOne(targetEntity = Teacher.class, mappedBy = "otherInfo", fetch = FetchType.LAZY)
    private Teacher teacher;

    public OtherInfo(String email, String address, Date birthDate) {
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public OtherInfo() {
    }
}
