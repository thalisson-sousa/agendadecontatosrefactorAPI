package com.devthalisson.agendadecontatosrefactor.controllers.handler;

import com.devthalisson.agendadecontatosrefactor.dto.CustomError;
import com.devthalisson.agendadecontatosrefactor.services.exceptions.IdNotFountException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IdNotFountException.class)
    public ResponseEntity<CustomError> IdNotFound(IdNotFountException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
