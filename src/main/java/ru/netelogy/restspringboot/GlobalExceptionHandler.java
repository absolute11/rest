package ru.netelogy.restspringboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseBody
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseBody
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}