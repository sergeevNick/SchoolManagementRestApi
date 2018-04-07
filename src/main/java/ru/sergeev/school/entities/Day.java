package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "DAYS")
public class Day {
    //done

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DAY_ID")
    private Integer dayId;

    @Column(name = "DAY_NAME")
    private String dayName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Schedule.class, mappedBy = "day")
    private Set<Schedule> schedules;

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Integer getDayId() {
        return dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public Day() {

    }
}