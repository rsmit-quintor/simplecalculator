package nl.ruben.simplecalculator.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiExceptionHandlingTest {

    @Test
    void handleArithmeticException() {
        ResponseEntity<Object> response = new ApiExceptionHandling().handleArithmeticException(new ArithmeticException("Test message"));
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Caught exception after API call: Test message", response.getBody());
    }
}