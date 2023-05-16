package jym.yeongmu.CRUD.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostRestController.class);
    private List<PostDto> postList;

    public PostRestController() {
        this.postList = new ArrayList<>();
    }
    //http://localhost:8080/post(이 포스터에 응답을 볼꺼야 할 때 응답을 해주기 위함이다)
    // Post /post
    @PostMapping()//뭔가를 create 를 할 때는 PostMapping 을 사용한다
    @ResponseStatus(HttpStatus.CREATED)
    public void creatPost(@RequestBody PostDto postDto) {
            logger.info(postDto.toString());
        this.postList.add(postDto);
    }
    //http://localhost:8080/post
    // Get /post (이러한 요청을 받았다.)
    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postList;
    }
    //Get / post / 0
    // Get /post?id=0 과의 차이점을 알아라.(특정 자원을 정확히 명시하기 위해서는 쿼리가 아닌 경로를 이용하기로 했다.)
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postList.get(id);
    }
    //post 는 없었던 자원을 만들어서 넣는다
    // 현제 보내고 있는데이터를 그 위치에 넣어주세요 (대체를 할 때 사용)
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ) {
        PostDto targerPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targerPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targerPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targerPost);
    }
    //Delete / post / 0
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id) {
        this.postList.remove(id);
    }
    //Post/post
    //Get / post/0/
    //Get/pst
    // Put /post/0/
    //Delete / post / 0

    //게시판 이라면 ?

    // Post / board
    //Get / board / 0 /
    //이런식으로
}
