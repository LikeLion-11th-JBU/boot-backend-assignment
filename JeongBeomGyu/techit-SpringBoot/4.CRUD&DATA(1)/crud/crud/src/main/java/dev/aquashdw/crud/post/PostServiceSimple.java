package dev.aquashdw.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service를 만들 때 => private final PostRepository를 필요로 했고, 생성자 파라미터에서 @Autowired(PostRepository를 만족하는 클래스를 Ioc Container에서 제공을 해서 (postRepository)에 자동으로 인자를 주입(dependency 인젝션)해준다.  )를 통해 Repository를 달라고 하니까, this.postRepository를 통해 postRepository를 준다

@Service
public class PostServiceSimple implements PostService{
    private static final Logger logger = LoggerFactory.getLogger(PostServiceSimple.class);
    private final PostRepository postRepository;        // PostRepository 구현이 어떤식으로 되어있는지 상관하지 않겠다라는 뜻이다.
    public PostServiceSimple(
            @Autowired PostRepository postRepository        // 생성자 호출을 할 때 postRepository를 전달 해줘라는 뜻. PostRepository 가 호출되는 과정이 PostPepository인데, 우리는 PostRepository 를 기준으로 서비스에서 사용하고 있다. -> Spring Ioc에서 해주는 부분인데, 인터페이스를 요구를 해도 PostRepository를 만족하는 인터페이스의 클래스(PostMeMoryRepository)를 가져다가, 현재 구현된 것중에서 우선적으로 구현되어있는 구현체(PostMeMoryRepository)를 가져온다.
    ) {
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        // TODO
        if(!this.postRepository.save(dto)){
            throw new RuntimeException("save failed");  // boolean으로 해놓은 이유 => 레포지토리의 구현의 형태가 문제가 생겼을 때 예외를 처리할 수 있다.
        }
//        this.postRepository.save(dto);  // 지금은 명백한 서비스가 구현이 된것이 아니므로 그냥 todo만 쓴다.
        // 이것뒤에 check validity를 쓰면 게시글이 어떤 게시판에 작성된것인데, 사용자가 그 게시판에 대해서 권한이 충분한지에 대한 부분들을 넣을 수 있다.
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);        //
    }

    @Override
    public void updatePost(int id, PostDto dto) {
        this.postRepository.update(id, dto);

    }

    @Override
    public void deletePost(int id) {
        this.postRepository.delete(id);

    }
}
