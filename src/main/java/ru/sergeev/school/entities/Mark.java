package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MARKS")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARK_ID")
    private Integer markId;

    @Column(name = "VALUE")
    private Integer value;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "STUDENT_ID")
    private User student;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Subject.class)
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    public Mark(Integer value) {
        this.value = value;
    }

    public Mark(Integer value, Date date) {
        this.value = value;
        this.date = date;
    }

    public Mark() {
    }

    public Integer getMarkId() {
        return markId;
    }

    public Integer getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setMarkId(Integer markId) {
        this.markId = markId;
    }

    public void setValue(Integer value) {
        if (value > 1 && value < 6) {
            this.value = value;
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
