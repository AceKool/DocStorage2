package com.main.java.com.docsstorage.docsstorage.Exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(Integer id){
        super("Couldn't find student with id: " + id);
    }
}
