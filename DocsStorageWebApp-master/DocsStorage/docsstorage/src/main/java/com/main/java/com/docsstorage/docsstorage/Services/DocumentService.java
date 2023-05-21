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

    public void save(Document document) {
        documentRepository.save(document);
    }

    public Document getById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public File getFile(Document document) {
        return new File(document.getFilePath());
    }
}


