package dev.Seungil.noticeboard.controller;

import dev.Seungil.noticeboard.dto.BoardDto;
import dev.Seungil.noticeboard.service.BoardService;
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
    @Operation(summary = "test", description = "Main api example")
    @GetMapping("/") // 메인화면
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1")Integer pageNum){
        List<BoardDto> boardDtoList = boardService.getBoardList(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);

        return "board/list.html";
    }
    @Operation(summary = "test", description = "writing api example")
    @GetMapping("/post") // 글쓰기
    public String write(){
        return "board/write.html";
    }
    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }
    @Operation(summary = "test", description = "post 'detail' api example")
    @GetMapping("/post/{no}") // 쓴거 누르면 detail하게 보여줌
    public String detail(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }
    @Operation(summary = "test", description = "edit api example")
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @Operation(summary = "test", description = "update api example")
    @PutMapping("/post/edit/{no}") // 수정
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @Operation(summary = "test", description = "delete api example")
    @DeleteMapping("/post/{no}") //삭제
    public String delete(@PathVariable("no") Long id){
        boardService.deletePost(id);

        return "redirect:/";
    }
    @Operation(summary = "test", description = "search api example")
    @GetMapping("/board/search") // 검색s
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }


}
