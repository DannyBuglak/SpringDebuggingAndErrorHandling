package com.pluralsight.hello_people.advice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@Order(Ordered.LOWEST_PRECEDENCE)
// assignableTypes = ...class for handling exceptions for specific controller
// basePackages = "..." a specific package to handle requests
@RestControllerAdvice   //(basePackages = "com.pluralsight.hello_people")
public class AppControllerAdvice {

//    @ExceptionHandler({Exception.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleAllException(HttpServletRequest request, Exception e) {
//        return "[AppControllerAdvice] Oops, cannot "
//                + request.getMethod() + " "
//                + request.getRequestURL()
//                + ". Exception: "
//                + e.getMessage();
//    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleAllException(HttpServletRequest request, Exception e) {
        var pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        pd.setTitle("Exception occurred");
        pd.setType(URI.create("https://www.someurl.com/errors/bad-request"));
        pd.setProperty("key", "value"); // Can be any key and value that I choose
        return pd;
    }

}
