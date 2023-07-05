package dev.SeungIL.jpa.exception;

public class PostNotExistException extends BaseException {
    public PostNotExistException(){
        super("target post does not exist");

    }
}
