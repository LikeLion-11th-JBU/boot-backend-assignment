package dev.aquashdw.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostInMemoryRepository implements PostRepository {

    private static final Logger logger = LoggerFactory.getLogger(PostInMemoryRepository.class);
    private final List<PostDto> postList;       // PostRepository 의 구현체 중에서 InMemory가 아니라 RDB, MYSqual이 들어가면 더 이상 List<PostDto>가 들어가 있지 않는다.

    public PostInMemoryRepository() {
        this.postList = new ArrayList<>();
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {   //find가 PostList를 넘어갔을 때 어떤식으로 작동을 할지에 대한 부분을 설정할 수 있다.
        return this.postList.get(id);
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);      // dto가 추가되었을 시 true이므로 return true와 동일하게 돌려준다.
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }

    @Override
    public boolean update(int id, PostDto postDto) {        // Repository에서 굳이 boolean값을 돌려주는 이유는 성공하지 못했을 때가 존재하기 때문이다.
        PostDto targetPost = this.postList.get(id); // id는 List의 인덱스값을 그대로 사용하고 있다. 해당 값을 targetPost라는 변수에 저장해준다. -> 업데이트를 하기위한 목적 타겟 게시글이다.
        if (postDto.getTitle() != null) {         // if문 2번 사용 ->제시자는 바꿀 수 없다는 가정하에 사용하기 때문이다. 아니면 if문을 3번 사용해야한다.
            targetPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targetPost.setContent(postDto.getContent());        // 이런 과정을 하는 이뉴는 targetPost 내용물 대신에 postdto에 날라 온것을 다시 사용할 수 있기 때문이다. 즉 @RequestBody를 통해 날라왔던 PostDto의 Body의 내용물에 title이나 content의 내용물이 없다면 targetPost의 내용도 바뀌기 때문이다.
        }   // Post 레포지토리지만 InMemory 형태로 만들어 졌다.
        this.postList.set(id, targetPost);      // 즉 postList의 id에 새로운 내용물로 가득한 targetPost를 넣는다. List의 범위를 넘어가서 500이라는 오류가 나올 수 있다.
        return true;
    }
}
