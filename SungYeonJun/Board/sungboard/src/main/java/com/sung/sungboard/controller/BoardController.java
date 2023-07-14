package com.sung.sungboard.controller;

import com.sung.sungboard.dto.BoardDto;
import com.sung.sungboard.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService){

        this.boardService = boardService;
    }
    @Operation(summary = "Main", description = "Main api 메인화면")
    @GetMapping("/") // 메인화면
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1")Integer pageNum){
        List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);

        return "board/list.html";
    }
    @Operation(summary = "Post", description = "Writing api 글쓰기 화면")
    @GetMapping("/post") // 글쓰기
    public String write(){
        return "board/write.html";
    }
    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
    @Operation(summary = "Detail", description = "post 'detail' api 게시글 보기")
    @GetMapping("/post/{no}") // 자세히
    public String detail(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }
    @Operation(summary = "Edit", description = "edit api")
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @Operation(summary = "Update", description = "update api 수정")
    @PutMapping("/post/edit/{no}") // 수정
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @Operation(summary = "Delete", description = "Delete api 삭제")
    @DeleteMapping("/post/{no}") //삭제
    public String delete(@PathVariable("no") Long id){
        boardService.deletePost(id);

        return "redirect:/";
    }
    @Operation(summary = "Search", description = "Search api 검색")
    @GetMapping("/board/search") // 검색
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }


}
