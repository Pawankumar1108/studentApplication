package com.pawan.studentForm.controller;

import com.pawan.studentForm.entity.StudentCredentialsEntity;
import com.pawan.studentForm.studentRepository.StudentCredentialsRepository;
import com.pawan.studentForm.studentService.StudentCredentialsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<StudentCredentialsEntity> getStudentById (@PathVariable Integer credentialsId)
    {
        return (credentialsId != null) ? studentCredentialsServices.getStudentById(credentialsId) : Optional.empty();
    }

    @PutMapping("/updateStudentByUserName")
    public ResponseEntity<?> updateStudentDetailsByUserName (@PathVariable String userName, @RequestBody StudentCredentialsEntity newStudentCredentials)
    {
        StudentCredentialsEntity user = studentCredentialsServices.getStudentByUserName(userName);
        if(userName!=null)
        {
            user.setUserName(newStudentCredentials.getUserName());
            user.setPassword(newStudentCredentials.getPassword());
            studentCredentialsServices.addNewStudentCredential(user);
        }

       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}

