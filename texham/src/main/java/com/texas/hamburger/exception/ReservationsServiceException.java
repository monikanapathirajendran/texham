package com.texas.hamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationsServiceException extends RuntimeException{
    public static final long serialVersionUID = 1L;
    public ReservationsServiceException(String message) {
        super(message);
    }
    public ReservationsServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
