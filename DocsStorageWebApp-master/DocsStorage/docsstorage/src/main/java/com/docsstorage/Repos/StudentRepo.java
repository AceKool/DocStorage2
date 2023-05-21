package com.docsstorage.Repos;

import com.docsstorage.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);
}
