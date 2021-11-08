package com.texas.hamburger.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BranchesServiceException extends RuntimeException{
    public static final long serialVersionUID = 1L;
    public BranchesServiceException(String message) {
        super(message);
    }
    public BranchesServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
