package jym.yeongmu.jpa;

import jym.yeongmu.jpa.exception.PostNotExistException;
import jym.yeongmu.jpa.exception.PostNotInBoardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("except")
public class ExceptTestController {
    @GetMapping("{id}")
    public void throwException(@PathVariable int id) {
        switch (id) {
            case 1:
                throw new PostNotExistException();
            case 2:
                throw new PostNotInBoardException();
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

//    @ExceptionHandler(BaseException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorResponseDto handleBaseException(BaseException exception){
//        return new ErrorResponseDto(exception.getMessage());
//    }
}
