package dev.aquashdw.jpa;

import dev.aquashdw.jpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class    PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;
    public PostService(@Autowired PostDao postDao){
        this.postDao = postDao;
    }
    public void createPost(PostDto postDto){
        this.postDao.createPost(postDto);

    }

    public PostDto readPost(int id){
        PostEntity postEntity = this.postDao.readPost(id);      // PostDao에서 PostEntity의 응답형태로 readPost 주기 때문에 PostEntity로 받아줘야한다.
        PostDto postDto = new PostDto (
           Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())        // 이러면 PostEntity의 BoardEntity 부분은 null 일 것인데 -> 이를 위해서 삼항연산자를 써준다.,
        ); // 이 함수는 PostDto를 반환값(돌려줘야하는데)으로 가지고 있는데 PostEntity가 왔으므로 PostEntity를 PostDto로 변환해주는 작업이 필요하다.
        return postDto;
    }
    public List<PostDto> readPostAll(){
        Iterator<PostEntity> iterator = this.postDao.readPostAll();     // 이것 역시 Iterator<PostEntity>를 List<PostDto>로 바꿔줘야한다.
        List<PostDto> postDtoList = new ArrayList<>();      // while문에서 iterator.next를 받아놓고, 반환값으로 사용을 할 PostDto라는 List를 ArrayList로 만들어준다.
        while (iterator.hasNext()){
            PostEntity postEntity = iterator.next();
            postDtoList.add(new PostDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())    // next를 받아왔으므로 next에 있는 값들을 postDto값으로 바꿔준다.
            ));
        }
        return postDtoList;

    }
    public void updatePost(int id, PostDto postDto){
        this.postDao.updatePost(id, postDto);

    }
    public void deletePost(int id){
        this.postDao.deletePost(id);

    }
}
