package com.TestBoard.demo.boardtest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/mainboard/posts")
@Api(tags = "게시판 API 연습")
public class BoardController {

    @Autowired
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "포스트 작성", notes = "게시글 생성 진행시켜")
    public RedirectView createPost(@RequestBody Board board) {
        boardService.createPost(board);
        return new RedirectView("/mainboard/posts");
    }

    @GetMapping("/read-all")
    @ApiOperation(value = "포스트 전부 가져오기", notes = "게시글 가져오기 진행시켜")
    public Page<Board> getAllPosts(Pageable pageable) {
        return boardService.getAllPosts(pageable);
    }

    @GetMapping("/read-one/{id}")
    @ApiOperation(value = "포스트 하나만 불러오기", notes = "특정 게시글 가져오기 진행시켜")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Board.class),
            @ApiResponse(code = 404, message = "Not Found")
    }) // 먼가 있어보여서
    
    public Board getPostById(@PathVariable Long id) {
        return boardService.getPostById(id);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "포스트 업데이트 하기",  notes = "게시글 업데이트 진행시켜")
    public Board updatePost(@PathVariable Long id, @RequestBody Board updatedPost) {
        return boardService.updatePost(id, updatedPost);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "포스트 삭제하기", notes = "게시글 삭제 진행시켜")
    public RedirectView deletePost(@PathVariable Long id) {
        boardService.deletePost(id);
        return new RedirectView("/mainboard/posts");
    }

}

//