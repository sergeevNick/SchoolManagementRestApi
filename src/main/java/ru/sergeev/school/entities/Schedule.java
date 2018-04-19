package ru.sergeev.school.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "SCHEDULES")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCHEDULE_ID")
    private Integer scheduleId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Grade.class)
    @JoinColumn(name = "GRADE_ID", nullable = false)
    private Grade grade;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Day.class)
    @JoinColumn(name = "DAY_ID", nullable = false)
    private Day day;

    @OneToMany(fetch = FetchType.EAGER, targetEntity = ScheduleRow.class, mappedBy = "schedule")
    @OrderBy("lesson ASC")
    private Set<ScheduleRow> rows;

    public Schedule() {
    }

    public Set<ScheduleRow> getRows() {
        return rows;
    }

    public Day getDay() {
        return day;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
