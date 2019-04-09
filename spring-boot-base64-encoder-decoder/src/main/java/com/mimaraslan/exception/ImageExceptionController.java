package com.mimaraslan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ImageExceptionController {
   @ExceptionHandler(value = ImageNotfoundException.class)
   public ResponseEntity<Object> exception(ImageNotfoundException exception) {
      return new ResponseEntity<>("Image not found", HttpStatus.NOT_FOUND);
   }
}