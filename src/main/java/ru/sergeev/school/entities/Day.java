package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "DAYS")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DAY_ID")
    private Integer dayId;

    @Column(name = "DAY_NAME", nullable = false)
    private String dayName;

    public Day() {
    }

    public Integer getDayId() {
        return dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
