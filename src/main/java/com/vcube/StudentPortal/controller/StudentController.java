
package com.vcube.StudentPortal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.vcube.StudentPortal.model.Student;
import com.vcube.StudentPortal.repo.StudentRepository;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // Create Student
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update Student
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setFname(student.getFname());
            existingStudent.setLname(student.getLname());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPhone(student.getPhone());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setLocation(student.getLocation());

            return studentRepository.save(existingStudent);
        }

        return null;
    }

    // Delete Student
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }
}
