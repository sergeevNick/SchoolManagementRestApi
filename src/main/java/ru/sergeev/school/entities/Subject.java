package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "SUBJECTS")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOM")
    private Integer room;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Mark.class, mappedBy = "subject")
    private Set<Mark> marks;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ScheduleRow.class, mappedBy = "subject")
    private Set<ScheduleRow> rows;

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public void setMarks(Set<Mark> marks) {
        this.marks = marks;
    }

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
