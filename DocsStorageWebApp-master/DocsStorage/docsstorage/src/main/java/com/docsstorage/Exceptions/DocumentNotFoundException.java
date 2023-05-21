package com.main.java.com.docsstorage.docsstorage.Exceptions;

public class DocumentNotFoundException extends RuntimeException{
    public DocumentNotFoundException(Integer id){
        super("Couldn't find object with id: " + id);
    }
}
