package edu.cit.yu.rainricrandy.campuseequipmentloan.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}