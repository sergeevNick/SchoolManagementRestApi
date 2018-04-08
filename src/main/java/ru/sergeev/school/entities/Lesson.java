package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "LESSONS")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LESSON_ID")
    private Integer lessonId;

    @Column(name = "START")
    private Time startTime;

    @Column(name = "END")
    private Time endTime;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ScheduleRow.class, mappedBy = "lesson")
    private Set<ScheduleRow> rows;

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public Lesson() {
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }
}
