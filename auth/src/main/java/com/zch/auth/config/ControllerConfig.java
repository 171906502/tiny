package com.zch.auth.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerConfig {

    @ExceptionHandler(Exception.class)
    public void handle(RuntimeException e) {
        log.warn("Returning HTTP 400 Bad Request", e);
        throw e;
    }
}