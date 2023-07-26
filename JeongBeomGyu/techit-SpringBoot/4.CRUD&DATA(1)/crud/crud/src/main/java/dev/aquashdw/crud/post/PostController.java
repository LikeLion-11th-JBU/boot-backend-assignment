package dev.aquashdw.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody   // Controller와 ResponseBody를 이렇게 붙여놓으면 RestController가 Controller에 있는 모든 ResponseBody에 붙여놓는것과 동일하다. 즉 PostController 클래스안의 모든 함수들이 ResponseBody가 붙어있는 형태로 함수선언이 완료된다.
//@RequestMapping("post")     // RequestMapping을 클래스에 붙여주면 이 클래스(PostController 안의 내용물에 있는 RequestMapping에 따라서 모두 다 앞쪽에 post라는 값이 붙는다.
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
//    private final List<PostDto> postList; 3. 을위해서 주석처리  // 오류가 나온 이유는 final을 선언했지만 postList가 초기화가 되어있지 않았기 때문이다. List로 선언해놨기 때문에 새로고침할 때마다 List가 초기화가 된다. -> 원래 만들어놨던 데이터가 다 날라간다.
    private final  PostService postService;     // 3. 더이상 POST 관리를 하지 않고 오로지 요청을 받고 응답을 보내는 역할로서 만들어주기 위해서
    public PostController(
            @Autowired PostService postService
    ){
        this.postService = postService;     // 3. 더이상 POST 관리를 하지 않고 오로지 요청을 받고 응답을 보내는 역할로서 만들어주기 위해서
//        postList = new ArrayList<>();      3. 을 위해서 주석처리 // 위에는 List로 postList를 선언하고 밑에는 postList를 ArrayList 객체로 선언한 이유는 ArrayList가 List의 인터페이스 구현체이기 때문이다.

    }
    // CRUD의 Create -> 게시글에 대한 데이터가 필요하다.
    @PostMapping("create")    // 밑의 RequestBody를 어떻게 보내줄지 결정 -> body가 필요할 때 post사용
    private void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postService.createPost(postDto);       //3. 을 위해서 추가
//        this.postList.add(postDto); 3. 을 위해서 주석처리 // new ArrayList로 새로 생성된 postList에 요청보내진(RequestBody) postDto가 들어가게 된다.
    }

    // CRUD의 Read -> 사용자가 조회
    @GetMapping("read-all")     // 사용자가 조회를 하는 메소드 -> body가 필요 없다 -> Get 사용
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postService.readPostAll();  // 3. 을 위해서 추가
//        return this.postList; 3. 을 위해서 주석처리
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){ // List를 안 쓴 이유는 PostDto를 하나만 읽어 들일 것이기 때문이다.
        logger.info("in read one");
        return this.postService.readPost(id);
//        return this.postList.get(id); 3. 을 위해서 주석처리

    }

    // CRUD의 update
    @PostMapping("update")
    public  void updatePost(
            @RequestParam("id") int id, // @RequestParam은 URL에서 쿼리 파라미터를 의미
            @RequestBody PostDto postDto                // @RequestBody는 Post요청의 Body를 의미한다. -> Java의 단점 중 하나 -> 내용물 하나하나를 확인해서 null인지 아닌지 확인을 해줘야한다.
            ){

        logger.info("target id: " + id);    // 3. 을 위해서 추가
        logger.info("update content" + postDto);    // 3. 을 위해서 추가
        this.postService.updatePost(id, postDto);   // 3. 을 위해서 추가
//        PostDto targetPost = this.postList.get(id); // id는 List의 인덱스값을 그대로 사용하고 있다. 해당 값을 targetPost라는 변수에 저장해준다. -> 업데이트를 하기위한 목적 타겟 게시글이다.
//        if(postDto.getTitle() != null){         // if문 2번 사용 ->제시자는 바꿀 수 없다는 가정하에 사용하기 때문이다. 아니면 if문을 3번 사용해야한다.
//            targetPost.setTitle(postDto.getTitle());
//        }
//        if(postDto.getContent() != null){
//            targetPost.setContent(postDto.getContent());        // 이런 과정을 하는 이뉴는 targetPost 내용물 대신에 postdto에 날라 온것을 다시 사용할 수 있기 때문이다. 즉 @RequestBody를 통해 날라왔던 PostDto의 Body의 내용물에 title이나 content의 내용물이 없다면 targetPost의 내용도 바뀌기 때문이다.
//        }     3. 을 위해서 주석처리
//        this.postList.set(id, targetPost); 3. 을위해 주석치리      // 즉 postList의 id에 새로운 내용물로 가득한 targetPost를 넣는다.


    }
    //CRUD의 Delete
    @DeleteMapping("delete")
    public void deletePost(@RequestParam("id") int id){
        this.postService.deletePost(id);
//        this.postList.remove(id); 3. 을 위해 주석처리
    }
    // controller를 사용하고 있는 클라이언트가 이미 있는 상황을 위한 처리 3. postService 처리를 한다.

}
