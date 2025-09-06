package com.pawan.studentForm.controller;

import com.pawan.studentForm.entity.StudentCredentialsEntity;
import com.pawan.studentForm.entity.StudentEntity;
import com.pawan.studentForm.studentRepository.StudentCredentialsRepository;
import com.pawan.studentForm.studentService.StudentCredentialsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/login")
public class StudentCredentialsController {

    @Autowired
    private StudentCredentialsServices studentCredentialsServices;

    @Autowired
    private StudentCredentialsRepository studentCredentialsRepository;

    @GetMapping
    public List<StudentCredentialsEntity> getAllStudents ()
    {
        return studentCredentialsServices.getAllStudent();
    }

    @PostMapping("/addNewStudentCredentials")
    public boolean addNewStudent (@RequestBody StudentCredentialsEntity newStudent)
    {
        studentCredentialsServices.addNewStudentCredential(newStudent);
        return true;
    }

    @GetMapping("/getStudentById/{credentialsId}")
    public boolean getStudentById (@PathVariable Integer credentialsId)
    {
        Optional<StudentCredentialsEntity> checkId = (credentialsId != null) ? studentCredentialsServices.getStudentById(credentialsId) : Optional.empty();
        return true;
    }

    @PutMapping("/updateStudentByUserName")
    public boolean updateStudentDetailsByUserName (@RequestBody StudentCredentialsEntity newStudentCredentials)
    {
        StudentCredentialsEntity userName = studentCredentialsServices.getStudentByUserName(newStudentCredentials.getUserName());
        if(userName!=null)
        {
            userName.setUserName(newStudentCredentials.getUserName());
            userName.setPassword(newStudentCredentials.getPassword());
            studentCredentialsServices.addNewStudentCredential(userName);
        }

       return true ;
    }
    
}

