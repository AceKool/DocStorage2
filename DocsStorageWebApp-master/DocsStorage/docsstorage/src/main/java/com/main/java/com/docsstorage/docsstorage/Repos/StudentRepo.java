package com.main.java.com.docsstorage.docsstorage.Repos;

import com.main.java.com.docsstorage.docsstorage.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}
