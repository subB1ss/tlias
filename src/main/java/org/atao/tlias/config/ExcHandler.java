package org.atao.tlias.config;

import lombok.extern.slf4j.Slf4j;
import org.atao.tlias.POJO.Result;
import org.atao.tlias.exceptions.IllegalOptException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.PrintStream;
import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ControllerAdvice
public class ExcHandler {
    @ExceptionHandler(IllegalOptException.class)
    public ResponseEntity<String> handler(Exception e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
