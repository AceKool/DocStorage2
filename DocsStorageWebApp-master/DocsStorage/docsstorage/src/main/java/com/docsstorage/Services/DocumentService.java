package com.main.java.com.docsstorage.docsstorage.Services;

import com.main.java.com.docsstorage.docsstorage.Models.Document;
import com.main.java.com.docsstorage.docsstorage.Repos.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepo documentRepo;

    public void uploadDocument(MultipartFile file, Long studentId) throws IOException {
        Student student = studentRepo.findById(studentId);
        if (student == null) {
            throw new NotFoundException("Student not found");
        }
        Document document = new Document();
        document.setName(file.getOriginalFilename());
        document.setType(file.getContentType());
        document.setSize(file.getSize());
        document.setContent(file.getBytes());
        document.setStudent(student);
        documentRepository.save(document);
    }

    public byte[] downloadDocument(Long id) {
        Document document = documentRepository.findById(id);
        if (document == null) {
            throw new NotFoundException("Document not found");
        }
        return document.getContent();
    }
}


