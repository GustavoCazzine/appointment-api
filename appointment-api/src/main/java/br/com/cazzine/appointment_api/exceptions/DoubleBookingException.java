package br.com.cazzine.appointment_api.exceptions;

public class DoubleBookingException extends RuntimeException {
    public DoubleBookingException(String message) {
        super(message);
    }
}
