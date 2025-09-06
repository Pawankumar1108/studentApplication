package com.pawan.studentForm.studentService;

import com.pawan.studentForm.entity.StudentCredentialsEntity;
import com.pawan.studentForm.studentRepository.StudentCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCredentialsServices {

    @Autowired
    StudentCredentialsRepository studentCredentialsRepository;


    public List<StudentCredentialsEntity> getAllStudent()
    {
        return studentCredentialsRepository.findAll();
    }

    public void addNewStudentCredential(StudentCredentialsEntity studentCredentialsEntity)
    {
        studentCredentialsRepository.save(studentCredentialsEntity);
    }

    public Optional<StudentCredentialsEntity> getStudentById(Integer credentialsId)
    {
        return studentCredentialsRepository.findById(credentialsId);
    }

     //TODO...
//    public void updateStudentDetails(Integer studentId,StudentCredentialsEntity studentCredentialsEntity)
//    {
//
//        Optional<StudentCredentialsEntity> credentialsId = studentCredentialsRepository.findById(studentId);
//        StudentCredentialsEntity updateStudentCredential = studentCredentialsRepository.save(studentCredentialsEntity);
//        studentCredentialsRepository.save(updateStudentCredential);
//    }

    public StudentCredentialsEntity getStudentByUserName(String userName)
    {
        return studentCredentialsRepository.getStudentByUserName(userName);
    }
}
