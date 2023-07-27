package dev.aquashdw.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("post")             // 게시글을 위한 것을 만듬으로 모든것은 post로 올 것이다.
public class PostRestController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;
//    private final List<PostDto> postList; 3. 을 위한 주석처리 구분하기 위해서 Service로 처리  // 초기화된 이후 더이상 postList에 새로운 값이 할당될 수 없다.

    public PostRestController(
            @Autowired PostService postService  //3. 을 위해서 추가
    ) {
        this.postService = postService;     // 3. 을 위해서 추가
//        this.postList = new ArrayList<>(); 3. 을 위한 주석처리
    }

    //http://localhost:8080까지 와서 서버에 도달한 다음 게시글을 보고 싶다면 /post -> //http://localhost:8080/post 형태로 요청을 보내야한다. -> 즉 localhost8080 의 post정보를 보고 싶다는 요청이다. 그러면 이 서버가 거기에 대해서 응답을 할 것이다.

    // CRUD 의 Create

    // http://localhost:8080/post
    // Post 요청 /post
    // RequestBody
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)// 클라이언트가 사용했을 요청이 어떻게 처리되었는지 추가하고 싶다면
    //HTTP 메소드들중 무엇을 쓸 것인지 -> post 무언가 create할 때 사용되는 메소드 -> 안쪽에 아무것도 쓰지 않으면 post요청에 의해 post경로로 들어오게 되면 안쪽에 있을 RequestBody에 따라서 Post 게시글을 만들어 내야된다
    public void createPost(@RequestBody PostDto postDto) {      //즉 RequestBody가 필요하다. -> 무언가 새로운 정보(데이터)를 전달할 때는 Body를 사용해주자.
        logger.info(postDto.toString());
        this.postService.createPost(postDto);   // 3. 을 위해서 추가
//        this.postList.add(postDto); 3. 을 위해서 주석처리
    }

    // CRUD 의 Read

    // http://localhost:8080/post
    // Get 요청 /post

    // Read 에서 사용하기를 권장되는 HTTP 메소드는 Get이다
    @GetMapping()
    public List<PostDto> readPostAll() {
        logger.info("in read post all");
        return this.postService.readPostAll(); // 3. 을 위해서 추가
//        return this.postList; 3. 을 위해서 주석처리
    }

    // GET /post/0/ -> 어떠한 특정한 자원을 명백하게 지시를 하기위해서는 경로를 사용한다.
    // GET /post?id=0 -> 쿼리 파라미터(리퀘스트 파라미터를 사용한 쿼리파라미터) -> 자원들 중에서 어떠한 질문을 하기위해서 사용하는 것이다.
    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id) {
        logger.info("in read post");
        return this.postService.readPost(id);   // 3. 을 위해서 추가
//        return this.postList.get(id); 3. 을 위해서 주석처리

    }

    // CRUD 의 update
    // Put 요청 /post/0
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)           //클라이언트가 사용했을 요청이 어떻게 처리되었는지 추가하고 싶다면 -> body를 계속기다를 수 있으므로 nocontent사용
    // postMapping은 없었던 자원을 새로 생성을 해서 만들어 넣는 것이다. <-> putMapping은 현재 보내고 있는 데이터를 그 위치에 "{id}"에 다시 넣어줘라는 뜻을 가지고 있따. => 새로운것을 만들 때 post 사용, 대체를 할 때 put 사용
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto        // 어떤 식으로 업데이트할 것인지에 대해서도 필요하다 -> 그것을 body에서 받아준다.
    ) {
        logger.info("target id: " + id);        // 3. 을 위해서 추가
        logger.info("update content" + postDto);    // 3. 을 위해서 추가
        this.postService.updatePost(id, postDto);   // 3. 을 위해서 추가
//        PostDto targetPost = this.postList.get(id); // id는 List의 인덱스값을 그대로 사용하고 있다. 해당 값을 targetPost라는 변수에 저장해준다. -> 업데이트를 하기위한 목적 타겟 게시글이다.
//        if (postDto.getTitle() != null) {         // if문 2번 사용 ->제시자는 바꿀 수 없다는 가정하에 사용하기 때문이다. 아니면 if문을 3번 사용해야한다.
//            targetPost.setTitle(postDto.getTitle());
//        }
//        if (postDto.getContent() != null) {
//            targetPost.setContent(postDto.getContent());        // 이런 과정을 하는 이뉴는 targetPost 내용물 대신에 postdto에 날라 온것을 다시 사용할 수 있기 때문이다. 즉 @RequestBody를 통해 날라왔던 PostDto의 Body의 내용물에 title이나 content의 내용물이 없다면 targetPost의 내용도 바뀌기 때문이다.
//        }
//        this.postList.set(id, targetPost);    3.을 위해서 주석처리  // 즉 postList의 id에 새로운 내용물로 가득한 targetPost를 넣는다.
    }

    // CRUD 의 delete
    // Delete 요청 /post/0
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id){
        this.postService.deletePost(id);    // 3을 위해서 추가
//        this.postList.remove(id); 3. 을 위해서 주석처리
    }


    // 지금 컨트롤러에 만들어져있는 Mapping
    // Post 요청 /post
    // GET 요청 /post/0
    // GET 요청 /post
    // Put 요청 /post/0
    // Delete 요청 /post/0

    // 모든 요청들이 post를 통해서 가고 있다. 게시글들을 위한 요청일 것이다라는 것을 경로상에 표시되어 있다. 특정한 자원에 대한 요청을 확인하고 싶다면은 그 경로에다가 그 자원에 대한 id를 제공하면 된다. 그 자원에서 어떤 작업을 하고 싶은지는 메소드로 표현이 되어있다.

    // 게시판에 대한 내용이 들어가는 경우
    // Post 요청 /board
    // GET 요청 /board/0
    // GET 요청 /board
    // Put 요청 /board/0
    // Delete 요청 /board/0
}
