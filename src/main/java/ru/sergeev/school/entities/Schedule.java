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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Grade.class)
    @JoinColumn(name = "CLASS_ID", nullable = false)
    private Grade scheduleGrade;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Day.class)
    @JoinColumn(name = "DAY_ID", nullable = false)
    private Day day;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = ScheduleRow.class, mappedBy = "schedule")
    @OrderBy("lesson ASC")
    private Set<ScheduleRow> rows;

    public Set<ScheduleRow> getRows() {
        return rows;
    }

    public void setRows(Set<ScheduleRow> rows) {
        this.rows = rows;
    }

    public void setScheduleGrade(Grade scheduleGrade) {
        this.scheduleGrade = scheduleGrade;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Schedule() {
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }
}
