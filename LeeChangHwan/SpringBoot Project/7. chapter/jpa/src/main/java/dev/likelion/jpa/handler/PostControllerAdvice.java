package dev.likelion.jpa.handler;

import dev.likelion.jpa.exception.BaseException;
import dev.likelion.jpa.exception.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class PostControllerAdvice {
   @ExceptionHandler(BaseException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(BaseException exception){
        return new ErrorResponseDto("@ExceptionHandler within ControllerAdvice");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponseDto handleValidException(
            MethodArgumentNotValidException exception){
       return new ErrorResponseDto(exception.getMessage());
    }
}
