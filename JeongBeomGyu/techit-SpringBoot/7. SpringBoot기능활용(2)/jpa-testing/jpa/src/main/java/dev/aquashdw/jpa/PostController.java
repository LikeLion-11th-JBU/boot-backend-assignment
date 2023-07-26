package dev.aquashdw.jpa;

import dev.aquashdw.jpa.aspect.LogExecutionTime;
import dev.aquashdw.jpa.aspect.LogParameters;
import dev.aquashdw.jpa.aspect.LogReturn;
import dev.aquashdw.jpa.exception.PostNotExistException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;
    }

    // Create
    @LogParameters
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@Valid @RequestBody PostDto dto){
        this.postService.createPost(dto);
    }

    //Read
    @LogReturn
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        return this.postService.readPost(id);

    }

    @LogExecutionTime
    @GetMapping("")
    public List<PostDto> readPostAll(){
        return this.postService.readPostAll();

    }

    // Update
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(@PathVariable("id") int id,
                           @RequestBody PostDto dto){
        this.postService.updatePost(id, dto);

    }

    //Delete
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void  deletePost(@PathVariable("id") int id){
        this.postService.deletePost(id);

    }

    @GetMapping("test-log")
    public void testLog(){
        logger.trace("TRACE Log Message");
        logger.debug("DEBUG Log Message");
        logger.info("INFO Log Message");
        logger.warn("WARN Log Message");
        logger.error("ERROR Log Message");
    }

    @PostMapping("test-valid")
    public void testValid(@Valid @RequestBody ValidTestDto dto){
        logger.warn(dto.toString());
    }

    @GetMapping("test-exception")
    public void throwException(){
        throw new PostNotExistException();
    }
}
