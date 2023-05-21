package com.docsstorage.Controllers;

import com.docsstorage.Models.Document;
import com.docsstorage.Services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("studentId") Long studentId) throws IOException {
        documentService.uploadDocument(file, studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable("id") Long id) {
        byte[] content = documentService.downloadDocument(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentLength(content.length);
        headers.set("Content-Disposition", "attachment; filename=" + id);
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
