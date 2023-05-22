package dev.SeungIL.jpa.exception;

public class InconsistentDataException extends BaseException{
    public InconsistentDataException(String message) {
        super("Post not in board");
    }
}
