package com.main.java.com.docsstorage.docsstorage.Controllers;

import com.main.java.com.docsstorage.docsstorage.Models.Document;
import com.main.java.com.docsstorage.docsstorage.Services.StudentService;
import com.main.java.com.docsstorage.docsstorage.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public void register(@RequestBody Student student) {
        studentService.register(student);
    }

    @PostMapping("/login")
    public Student login(@RequestBody Map<String, String> userInfo) {
        String id = userInfo.get("id");
        String email = userInfo.get("email");
        String password = userInfo.get("password");
        return studentService.login(email, password);
    }

    @GetMapping("/{id}/documents")
    public List<Document> getDocuments(@PathVariable Long id) {
        Student student = studentService.getById(id);
        return studentService.getDocuments(student);
    }
}
