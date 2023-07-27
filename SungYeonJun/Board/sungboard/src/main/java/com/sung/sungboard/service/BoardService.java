package com.sung.sungboard.service;

import com.sung.sungboard.domain.entity.Board;
import com.sung.sungboard.domain.repository.BoardRepository;
import com.sung.sungboard.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private BoardRepository boardRepository;
    private static final int BLOCK_PAGE_NUM_COUNT = 5; //블럭에 존재하는 페이지 수
    private static final int PAGE_POST_COUNT = 4; // 한 페이지에 존재하는 게시글 수

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    @Transactional
    public List<BoardDto> searchPosts(String keyword){
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if(boards.isEmpty()) return boardDtoList;

        for(Board board : boards){
            boardDtoList.add(this.convertEntityToDto(board));
        }

        return boardDtoList;
    }

    private BoardDto convertEntityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .build();
    }
    @Transactional
    public Long savePost(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional
    public List<BoardDto> getBoardList(Integer pageNum){
        //List<Board> boards = boardRepository.findAll();
        Page<Board> page = boardRepository
                .findAll(PageRequest
                        .of(pageNum-1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdDate")));
        List<BoardDto> boardDtoList = new ArrayList<>();
        List<Board> boards = page.getContent();
        for(Board board : boards) {
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .createdDate(board.getCreatedDate())
                    .build();

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    public Integer[] getPageList(Integer curPageNum){
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        Double PostsTotalCount = Double.valueOf(this.getBoardCount());

        Integer totalLastPageNum = (int)(Math.ceil((PostsTotalCount/PAGE_POST_COUNT)));

        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT : totalLastPageNum;

        curPageNum = (curPageNum<=3) ? 1 : curPageNum-2;

        for(int val = curPageNum, i = 0; val <= blockLastPageNum; val++, i++){
            pageList[i] = val;
        }
        return pageList;
    }

    @Transactional
    public Long getBoardCount(){
        return boardRepository.count();
    }

    @Transactional
    public BoardDto getPost(Long id){
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdDate(board.getCreatedDate())
                .build();

        return boardDto;
    }

    @Transactional
    public void deletePost(Long id){
        boardRepository.deleteById(id)  ;
    }
}

