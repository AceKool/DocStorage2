package com.main.java.com.docsstorage.docsstorage.Services;

import com.main.java.com.docsstorage.docsstorage.Models.Student;
import com.main.java.com.docsstorage.docsstorage.Models.Document;
import com.main.java.com.docsstorage.docsstorage.Repos.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public void register(Student student) {
        StudentRepo.save(student);
    }
    public Student login(String email, String password) {
        Student student = studentRepo.findByEmail(email);
        if (student == null || !student.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        return student;
    }

    public List<Document> getDocuments(Student student) {
        return documentRepo.findAllByStudent(student);
    }
}
