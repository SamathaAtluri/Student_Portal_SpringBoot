package com.vcube.StudentPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vcube.StudentPortal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}