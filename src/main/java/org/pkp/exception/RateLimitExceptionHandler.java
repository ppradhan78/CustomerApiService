package org.pkp.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.pkp.model.ErrorResponse;

@RestControllerAdvice
public class RateLimitExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    public ErrorResponse handleRateLimit(RequestNotPermitted ex) {
        return new ErrorResponse(
                429,
                "Too many requests. Please try again later."
        );
    }
}
