package dev.likelion.jpa.exception;

public class PostNotInBoardException extends BaseException{
    public PostNotInBoardException() {
        super("Post not in board");
    }
}
