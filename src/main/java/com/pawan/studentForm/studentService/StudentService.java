package com.pawan.studentForm.studentService;

import com.pawan.studentForm.entity.StudentEntity;
import com.pawan.studentForm.studentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

 @Autowired
 private StudentRepository studentRepository;

  public List<StudentEntity> getAllStudent()
  {
       return studentRepository.findAll();
  }

  public void addNewStudents(StudentEntity studentEntity)
  {
      studentRepository.save(studentEntity);
  }

  public Optional<StudentEntity> getStudentById(Integer studentId)
  {

     return studentRepository.findById(studentId);
//      Optional<StudentEntity> studentEntity = studentId != null ? studentRepository.findById(studentId) : Optional.empty();
//      return studentEntity;
  }

    public void updateStudentDetails(Integer studentId,StudentEntity studentEntity)
    {
        if (studentId != null && studentId.equals(studentEntity.getStudentId()))
            studentRepository.save(studentEntity);
    }
}
