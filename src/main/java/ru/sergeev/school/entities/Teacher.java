package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "TEACHERS")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEACHER_ID")
    private Integer teacherId;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "USER_ID")
    private User login;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NAME_ID")
    private Name name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OTHER_INFO_ID")
    private OtherInfo otherInfo;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ScheduleRow.class, mappedBy = "teacher")
    private Set<ScheduleRow> rows;

    public Teacher(Name name, OtherInfo otherInfo) {
        this.name = name;
        this.otherInfo = otherInfo;
    }

    public Teacher() {
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public Name getName() {
        return name;
    }

    public OtherInfo getOtherInfo() {
        return otherInfo;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public void setLogin(User login) {
        this.login = login;
    }

    public void setOtherInfo(OtherInfo otherInfo) {
        this.otherInfo = otherInfo;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
