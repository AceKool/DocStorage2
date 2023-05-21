package com.main.java.com.docsstorage.docsstorage;

import com.main.java.com.docsstorage.docsstorage.Exceptions.CustomNotFoundException;
import com.main.java.com.docsstorage.docsstorage.Exceptions.DocumentNotFoundException;
import com.main.java.com.docsstorage.docsstorage.Exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Обработчик вызываемых в контроллерах ошибок
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<String> handleDocumentNotFoundException(DocumentNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(CustomNotFoundException.class)
    // Метод возвращает статус и сообщение об ошибке. Обернуто в map, чотобы не вызывать ошибку со статусом
    public ResponseEntity<Map<String, String>> handleCustomNotFoundException(CustomNotFoundException ex){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }
}
