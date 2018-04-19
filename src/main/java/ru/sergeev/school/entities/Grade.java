package ru.sergeev.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "GRADES")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GRADE_ID")
    private Integer gradeId;

    @Column(name = "NUMBER")
 //   @OrderBy("number ASC")
    private String number;

    public Grade(String number) {
        this.number = number;
    }

    public Grade() {
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public String getNumber() {
        return number;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
