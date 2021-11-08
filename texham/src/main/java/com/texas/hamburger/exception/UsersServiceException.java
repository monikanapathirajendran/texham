package com.texas.hamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersServiceException extends  RuntimeException {
    public static final long serialVersionUID = 1L;

    public UsersServiceException(String message) {
        super(message);
    }
    public UsersServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
