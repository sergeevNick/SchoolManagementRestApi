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

    public Subject() {
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public Integer getRoom() {
        return room;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
