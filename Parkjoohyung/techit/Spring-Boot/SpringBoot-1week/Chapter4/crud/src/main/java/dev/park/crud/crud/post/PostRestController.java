package dev.park.crud.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("post")
public class PostRestController {
    private static Logger logger = LoggerFactory.getLogger(PostController.class);
//    private final List<PostDto> postList;
    private final PostService postService;

    public PostRestController(
            @Autowired PostService postService
    ){
//        this.postList = new ArrayList<>();
        this.postService = postService;
    }

//    http://localhost:8080/post
//    REQUEST_BODY

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
//        this.postList.add(postDto);
        this.postService.createPost(postDto);
    }

    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
//        return this.postList;
        return this.postService.readPostAll();
    }



    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
//        return this.postList.get(id);
        return this.postService.readPost(id);
    }


    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//현재 보내는 데이터를 그 위치에 넣는다
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
//        PostDto targetPost = this.postList.get(id);
//        if (postDto.getTitle() != null) {
//            targetPost.setTitle(postDto.getTitle());
//        }
//        if (postDto.getContent() != null) {
//            targetPost.setContent(postDto.getContent());
//        }
//        this.postList.set(id, targetPost);
        logger.info("target id : " + id);
        logger.info("update content : " + postDto);
        this.postService.updatePost(id, postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") int id){
//        this.postList.remove(id);
        this.postService.deletePost(id);
    }


    // POST /post
    // GET /post/0
    // GET /post?id=0
    // PUT /post/0
    // DELETE /post/0

    // POST /board
    // GET /board/0
    // GET /board?id=0
    // PUT /board/0
    // DELETE /board/0
}
