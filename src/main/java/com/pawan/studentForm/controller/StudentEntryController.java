package com.pawan.studentForm.controller;

import com.pawan.studentForm.entity.StudentEntity;
import com.pawan.studentForm.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentEntryController {

    @Autowired
    StudentService studentService;

//    @Autowired
//    StudentRepository studentRepository;

    //private Map<Integer,StudentEntity> studentDetails = new HashMap<>();

    @GetMapping("/getAllStudents")
    public List<StudentEntity> getAllStudents ()
    {
        return studentService.getAllStudent();
    }

    @PostMapping("/addNewStudent")
    public boolean addNewStudent (@RequestBody StudentEntity newStudent)
    {
        studentService.addNewStudents(newStudent);
        return true;
    }

    @GetMapping("/getStudentById/{studentId}")
    public boolean getStudentById (@PathVariable Integer studentId)
    {
        Optional<StudentEntity> getStatus = (studentId != null) ? studentService.getStudentById(studentId) : Optional.empty();
        return true;
    }

    @PutMapping("/updateStudentById/{studentId}")
    public boolean updateStudentDetailsById (@PathVariable Integer studentId,
                                      @RequestBody StudentEntity studentEntity)
    {
        Optional<StudentEntity> getStatus = (studentId != null) ? studentService.updateStudentDetails(studentId) : Optional.empty();
        return true ;
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
