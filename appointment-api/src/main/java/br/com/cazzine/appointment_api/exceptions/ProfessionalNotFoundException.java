package br.com.cazzine.appointment_api.exceptions;

public class ProfessionalNotFoundException extends RuntimeException {
    public ProfessionalNotFoundException(String message) {
        super(message);
    }
}
