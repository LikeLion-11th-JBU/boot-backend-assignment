package com.TestBoard.demo.boardtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board createPost(Board board){
        return boardRepository.save(board);
    }

    public Page<Board> getAllPosts(Pageable pageable){
        return boardRepository.findAll(pageable);
    }
    
    public Board getPostById(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            return optionalBoard.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id:" + id);
        }
    }

    public Board updatePost(Long id, Board updatePost){
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setTitle(updatePost.getTitle());
            board.setContent(updatePost.getContent());
            board.setWriter(updatePost.getWriter());
            return boardRepository.save(board);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id:" + id);
        }
    }

    public void deletePost(Long id) {
        Optional<Board> optionalPost = boardRepository.findById(id);
        if (optionalPost.isPresent()) {
            boardRepository.delete(optionalPost.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found with id:" + id);
        }
    }

    
    
// 업데이트 부분 오류
//    public Board postUpdate(Long id, Board board){
//        return boardRepository.update(id, board);
//    }

}
