package com.example.jpa;

import com.example.jpa.aspect.LogExceptionTime;
import com.example.jpa.aspect.LogArguments;
import com.example.jpa.aspect.LogReturn;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final Gson gson;

    public PostController(
            @Autowired PostService postService
            // Spring IOC container에 PostService의 Bean을 요구
//            @Autowired GsonComponent gson
    ) {
        this.postService = postService;
//        this.gson = gson.getGson();
    }

    @LogArguments
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(
            @Valid
            @RequestBody PostDto dto
    ){
        this.postService.createPost(dto);
    // 질문 or 복습 => 이거 왜 PostDto지?

    }


    @LogExceptionTime
    @GetMapping("{id}")
    public PostDto readPost(
            @PathVariable("id") int id
    ){
        return this.postService.readPost(id);
    }

    @LogReturn
    @GetMapping("")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<PostDto> readPostAll() {
        return this.postService.readPostAll();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto dto
    ){
        this.postService.updatePost(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(
            @PathVariable("id") int id
    ){
        this.postService.deletePost(id);
    }
    @GetMapping("test-log")
    public void testLog(){
        // 로그를 남기면서 어떤 오류가 있었는지
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");

    }

    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto dto) {
        logger.warn(dto.toString());
    }

}
