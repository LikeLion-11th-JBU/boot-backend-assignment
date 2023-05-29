package jym.yeongmu.jpa.exception.handler;

import jym.yeongmu.jpa.exception.BaseException;
import jym.yeongmu.jpa.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleException(BaseException exception) {
        return new ErrorResponseDto(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handleValidException(
            MethodArgumentNotValidException exception){
        return new ErrorResponseDto(exception.getMessage());
    }
}
