package com.pawan.studentForm.controller;

import com.pawan.studentForm.entity.StudentEntity;
import com.pawan.studentForm.studentRepository.StudentDemo;
import com.pawan.studentForm.studentRepository.StudentRepository;
import com.pawan.studentForm.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentEntryController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

    //private Map<Integer,StudentEntity> studentDetails = new HashMap<>();

    @GetMapping("/getAllStudents")
    public List<StudentEntity> getAllStudents ()
    {
        return studentRepository.findAll();
    }

    @PostMapping("/addNewStudent")
    public boolean addNewStudent (@RequestBody StudentEntity newStudent)
    {
        studentRepository.save(newStudent); // Instead of creating extra class for Implementing Bussiness logic we can use it directly..
        return true;
    }

    @GetMapping("/getStudentById/{studentId}")
    public Optional<StudentEntity> getStudentById (@PathVariable Integer studentId)
    {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/updateStudentById/{studentId}")
    public StudentEntity updateStudentById (@PathVariable Integer studentId)
    {
        return null ;
    }

    /*@DeleteMapping("/removeStudentById/{studentId}")
    public StudentEntity removeStudentById (@PathVariable Integer studentId)
    {
        return studentDetails.remove(studentId) ;
    }

    @DeleteMapping("/removeAllStudents")
    public void removeAllStudents()
    {
        studentDetails.clear();
    }
*/




}
