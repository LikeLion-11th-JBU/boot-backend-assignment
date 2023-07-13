package com.board.crudboard.service;

import com.board.crudboard.entity.Board;
import com.board.crudboard.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {


    @Autowired
    private BoardRepository boardRepository;

    //글작성
    public void write(Board board) {
        boardRepository.save(board);
    }

    //게시글 리스트
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    //특정 게시물 불러오기
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }

}
