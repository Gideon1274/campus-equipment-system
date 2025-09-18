package edu.cit.yu.rainricrandy.campuseequipmentloan.exception;

public class BusinessRuleViolationException extends RuntimeException {
    public BusinessRuleViolationException(String message) {
        super(message);
    }
}