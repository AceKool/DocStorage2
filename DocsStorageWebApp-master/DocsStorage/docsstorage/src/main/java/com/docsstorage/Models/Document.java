package com.docsstorage.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="documents")
@Data
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String fileName;
    @Column(name = "filepath")
    private String filepath;
    @Column(name = "student")
    private Student student;

    public void updateDocument(Document document) {
        if (Document.fileName != null)        { this.fileName = Document.fileName; }

        if (Document.filepath != null)    { this.filepath = Document.filepath; }

        if (Document.student != null) { this.student = Document.student; }


    }

    // Connection with Document table
    @JsonIgnore
    @ManyToOne(mappedBy = "document")
    private List<Document> students;

}
