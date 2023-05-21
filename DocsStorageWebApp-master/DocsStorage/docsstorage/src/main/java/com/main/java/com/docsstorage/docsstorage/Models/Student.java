package com.main.java.com.docsstorage.docsstorage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public void updateStudent(Student student) {
        if (student.name != null) {
            this.name = student.name;
        }

        if (student.email != null) {
            this.email = student.email;
        }

        if (student.password != null) {
            this.password = student.password;
        }

        if (student.documents != null) {
            this.documents = student.documents;
        }

    }// Connection with ORDER table
    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<Document> documents;
}
