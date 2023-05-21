package com.main.java.com.docsstorage.docsstorage.Repos;

import com.main.java.com.docsstorage.docsstorage.Models.Student;
import com.main.java.com.docsstorage.docsstorage.Models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepo extends JpaRepository<Document, Integer> {
    List<Document> findAllByStudent(Student student);
}