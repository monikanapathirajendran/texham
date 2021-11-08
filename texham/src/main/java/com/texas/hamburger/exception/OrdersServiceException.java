package com.texas.hamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrdersServiceException extends RuntimeException{
    public static final long serialVersionUID = 1L;
    public OrdersServiceException(String message) {
        super(message);
    }
    public OrdersServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
