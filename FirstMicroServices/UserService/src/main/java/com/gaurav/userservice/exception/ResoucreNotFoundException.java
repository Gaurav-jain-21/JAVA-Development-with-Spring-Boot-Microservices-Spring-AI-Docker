package com.gaurav.userservice.exception;

public class ResoucreNotFoundException extends RuntimeException {
    public ResoucreNotFoundException(String s){
        super("Resource Not Found on Server");
    }
}
