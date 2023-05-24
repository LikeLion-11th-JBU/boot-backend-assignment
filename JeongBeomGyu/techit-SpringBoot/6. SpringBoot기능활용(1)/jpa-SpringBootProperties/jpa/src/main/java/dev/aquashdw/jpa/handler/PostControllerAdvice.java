package dev.aquashdw.jpa.handler;

import dev.aquashdw.jpa.exception.BaseException;
import dev.aquashdw.jpa.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PostControllerAdvice {
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(BaseException exception){
        return new ErrorResponseDto(exception.getMessage());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ErrorResponseDto handleValidException(
            MethodArgumentNotValidException exception      // 실제로 발생한 Exception
    ){
        return new ErrorResponseDto(exception.getMessage());
    }
}
