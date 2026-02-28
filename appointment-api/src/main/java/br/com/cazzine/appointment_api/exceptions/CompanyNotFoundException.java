package br.com.cazzine.appointment_api.exceptions;

public class CompanyNotFound extends RuntimeException{
    public CompanyNotFound(String message) {
        super(message);
    }
}
