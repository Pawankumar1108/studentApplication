package com.pawan.studentForm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer studentId;
    private String studentName;
    private String studentCourse;
    private Integer studentRollNo;
    private Integer studentClass;
    private long studentMarks;
    private double studentPercentage;

}
