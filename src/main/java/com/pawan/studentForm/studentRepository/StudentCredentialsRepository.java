package com.pawan.studentForm.studentRepository;

import com.pawan.studentForm.entity.StudentCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCredentialsRepository extends JpaRepository<StudentCredentialsEntity,Integer> {

    StudentCredentialsEntity getStudentByUserName(String userName);
}
