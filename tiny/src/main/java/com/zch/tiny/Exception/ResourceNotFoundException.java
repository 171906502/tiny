package com.zch.tiny.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String userNotFound) {
       super(userNotFound);
    }
}
