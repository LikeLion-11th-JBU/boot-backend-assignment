package dev.aquashdw.jpa;

import dev.aquashdw.jpa.exception.BaseException;
import dev.aquashdw.jpa.exception.ErrorResponseDto;
import dev.aquashdw.jpa.exception.PostNotInBoardException;
import dev.aquashdw.jpa.exception.PostNotExistException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id){
        switch (id){
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(BaseException.class)
    public ErrorResponseDto handleBaseException(BaseException exception, HttpServletResponse response){
        return new ErrorResponseDto(exception.getMessage());

    }
}
