package com.pawan.studentForm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class StudentCredentialsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer credentialsId;

    @NotNull
    public String userName;

    @NotNull
    private String password;

    @ElementCollection
    List<StudentEntity> studentList = new ArrayList<>();


}
