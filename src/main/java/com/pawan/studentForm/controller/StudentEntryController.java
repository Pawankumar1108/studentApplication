package com.pawan.studentForm.controller;

import com.pawan.studentForm.entity.StudentCredentialsEntity;
import com.pawan.studentForm.entity.StudentEntity;
import com.pawan.studentForm.studentService.StudentCredentialsServices;
import com.pawan.studentForm.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentEntryController {

    @Autowired
    private StudentCredentialsServices studentCredentialsServices;

    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<?> getAllStudents()
    {
        List<StudentEntity> getAllStudentList = studentService.getAllStudent();
              return getAllStudentList != null && !getAllStudentList.isEmpty()
                ? new ResponseEntity<>(getAllStudentList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);

//        List<StudentEntity> getAllStudentList = studentService.getAllStudent();
//        if(getAllStudentList!= null && getAllStudentList.isEmpty())
//        {
//            return new ResponseEntity<>(getAllStudentList, HttpStatus.FOUND);
//        }
    }

//Getting Student By their Credentials.

    @GetMapping("/getAllStudentsByStudentName")
    public ResponseEntity<?> getAllStudentsByStudentName (@PathVariable String studentName)
    {
        StudentCredentialsEntity studentEntry = studentCredentialsServices.getStudentByUserName(studentName);
        List<StudentEntity> getAllStudentList = studentEntry.getStudentList();
        return getAllStudentList != null && !getAllStudentList.isEmpty()
                ? new ResponseEntity<>(getAllStudentList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PostMapping("/addNewStudent")
//    public ResponseEntity<StudentEntity> addNewStudent (@RequestBody StudentEntity newStudent)
//    {
//        try
//        {
//            studentService.addNewStudents(newStudent, studentName);
//            return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
//        }catch (Exception ex)
//        {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//Add Student According to StudentNames.
    @PostMapping("/addNewStudent/{studentName}")
    public ResponseEntity<StudentEntity> addStudentByStudentName (@RequestBody StudentEntity newStudent,@PathVariable String studentName)
    {
        try
        {
            studentService.addNewStudents(newStudent,studentName);
            return new ResponseEntity<>(newStudent,HttpStatus.CREATED);
        }catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getStudentById/{studentId}")
    public Optional<StudentEntity> getStudentById (@PathVariable Integer studentId)
    {

//        if (studentId != null) {
//            studentService.getStudentById(studentId);
//             new ResponseEntity<>(HttpStatus.FOUND);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

//        try{
           return studentService.getStudentById(studentId);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }


//        return  studentService.getStudentById(studentId).isPresent()
//                ? new ResponseEntity<>(studentId,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateStudentById/{studentId}")
    public ResponseEntity<StudentEntity> updateStudentDetailsById (@PathVariable Integer studentId,
                                      @RequestBody StudentEntity studentEntity)
    {
       try
       {
           studentService.updateStudentDetails(studentId, studentEntity);
           return new ResponseEntity<>(studentEntity, HttpStatus.OK);
       } catch (Exception e)
       {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

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
