package com.pluralsight.hello_people.advice;

import com.pluralsight.hello_people.controllers.PeopleController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.core.annotation.Order;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice(assignableTypes = { PeopleController.class })
public class PeopleControllerAdvice {

    @ExceptionHandler({IndexOutOfBoundsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleExceptions(HttpServletRequest request, Exception e) {
        String method = request.getMethod();
        return "[PeopleControllerAdvice] Oops, cannot "
                + method
                + " " + request.getRequestURL()
                + " this request. Exception: "
                + e.getMessage();
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMessageNotReadableException(HttpServletRequest request, Exception e) {
        return "[PeopleControllerAdvice] Oops, cannot read message with "
                + request.getMethod() + " "
                + request.getRequestURL()
                + ". Exception: "
                + e.getMessage();
    }

}
