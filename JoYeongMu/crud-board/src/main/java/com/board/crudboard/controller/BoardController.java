package com.board.crudboard.controller;

import com.board.crudboard.entity.Board;
import com.board.crudboard.repository.BoardRepository;
import com.board.crudboard.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Tag(name = "Controller")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    @Operation(summary = "게시판 작성 화면", description = "게시판 작성 화면 입니다..", tags = {"View"})
    public String boardWriteForm() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    @Operation(summary = "게시판 작성 완료 요청", description = "게시판 작성 완료 요청입니다.", tags = {"Task"})
    public String boardWritePro(Board board) {

        board.setCreatedDate(LocalDateTime.now());
        boardService.write(board);
        return "redirect:/board/list";
    }
    @GetMapping("/board/list")
    @Operation(summary = "게시판 리스트 화면", description = "게시판 리스트 화면 입니다.", tags = {"View"})
    public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> list = boardService.boardList(pageable);

        int nowPage = list.getNumber() + 1;
        int totalPages = list.getTotalPages();
        int maxPages = 10; // 한 번에 표시할 최대 페이지 번호 개수
        int pageRange = (nowPage - 1) / maxPages; // 현재 페이지 그룹의 범위

        int startPage = pageRange * maxPages + 1;
        int endPage = Math.min(startPage + maxPages - 1, totalPages);

        model.addAttribute("list", list);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "boardlist";
    }

    @GetMapping("/board/view")
    @Operation(summary = "게시글 상세 화면", description = "게시글 상세 화면입니다.", tags = {"View"})
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardview";
    }


    @GetMapping("/board/delete")
    @Operation(summary = "게시글 삭제 요청", description = "게시글 삭제 요청 입니다.", tags = {"Task"})
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";

    }

    @GetMapping("/board/modify/{id}")
    @Operation(summary = "게시판 수정 화면", description = "게시판 수정 화면 입니다.", tags = {"View"})
    public String boardModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardmodify";
    }


    @PostMapping("/board/update/{id}")
    @Operation(summary = "게시판 수정 완료 요청", description = "게시판 수정 완료 요청 입니다.", tags = {"Task"})
    public String boardUpdate(@PathVariable("id") Integer id,
                              Board board) {

        Board boardTemp = boardService.boardView(id);
        boardTemp.setWriter(board.getWriter());
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardTemp.setModifiedDate(LocalDateTime.now());
        boardService.write(boardTemp);


        return "redirect:/board/list";
    }
}
