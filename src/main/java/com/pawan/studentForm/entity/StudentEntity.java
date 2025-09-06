package com.pawan.studentForm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(String studentCourse) {
        this.studentCourse = studentCourse;
    }

    public Integer getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Integer studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public Integer getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(Integer studentClass) {
        this.studentClass = studentClass;
    }

    public long getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(long studentMarks) {
        this.studentMarks = studentMarks;
    }

    public double getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(double studentPercentage) {
        this.studentPercentage = studentPercentage;
    }
}
