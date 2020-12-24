package nl.ruben.simplecalculator.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ApiExceptionHandling {

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex) {
        String message = "Caught exception after API call: " + ex.getMessage();
        return baseHandler(message, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> baseHandler(String message, HttpStatus status){
        return new ResponseEntity<>(message, new HttpHeaders(), status);
    }

}
