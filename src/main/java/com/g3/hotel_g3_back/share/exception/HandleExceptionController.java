package com.g3.hotel_g3_back.share.exception;

import com.g3.hotel_g3_back.share.exception.model.ErrorResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandleExceptionController {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponseModel> handleDatabaseError(HttpServletRequest req, GenericException e) {
        return new ResponseEntity<>(new ErrorResponseModel(e.getMessage()), HttpStatus.CONFLICT);
    }

}
