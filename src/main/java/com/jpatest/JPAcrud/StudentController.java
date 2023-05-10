package com.jpatest.JPAcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentRepository studentRepository;
    private Student student;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // add a student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // delete student
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    // modify student
    @PutMapping("/students/{id}")
    public Student modifyStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student studentToModify = studentOptional.get();
            studentToModify.setFirstName(student.getFirstName());
            studentToModify.setLastName(student.getLastName());
            studentToModify.setEmail(student.getEmail());
            studentToModify.setAge(student.getAge());
            return studentRepository.save(studentToModify);
        }
        return null;
    }

}
