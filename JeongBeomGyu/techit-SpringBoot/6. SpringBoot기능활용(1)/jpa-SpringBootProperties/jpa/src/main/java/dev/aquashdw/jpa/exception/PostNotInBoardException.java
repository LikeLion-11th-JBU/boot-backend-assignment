package dev.aquashdw.jpa.exception;



public class InconsistentDataException extends BaseException {
    public InconsistentDataException(){
        super("Post not in board");
    }
}
