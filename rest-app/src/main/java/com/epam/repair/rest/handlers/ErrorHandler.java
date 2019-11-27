package com.epam.repair.rest.handlers;

import com.epam.repair.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Error handler.
 */
@ControllerAdvice
public class ErrorHandler {

    /**
     * Error handler error handler order.
     *
     * @param response the response
     * @throws IOException the io exception
     */
    @ExceptionHandler(OrderNotFoundException.class)
    public void errorHandlerOrderNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}