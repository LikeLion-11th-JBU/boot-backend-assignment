package com.example.jpa;

import com.example.jpa.entity.PostEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 드디어 로거, 로거팩토리에 대해서 알려준다!!
// LoggerFactory 는 자바에서 일반적으로 통용되는 Logging 라이브러리인 Logback 이라는 프레임워크였다.
// 즉! LoggerFactory 를 통해서 가져온 logger 는
// Logback 의 logger 에서 제공하는 Logger Interface 다.
// => 우린 이미 Logback 을 사용하고 있었다.

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class PostService {
    private static final Logger logger = LoggerFactory.getLogger(PostService.class);
    private final PostDao postDao;
    public PostService(@Autowired PostDao postDao){
        this.postDao = postDao;
    }
    public void createPost(PostDto postDto){
        this.postDao.createdPost(postDto);
    }

    public PostDto readPost(int id){
        PostEntity postEntity = this.postDao.readPost(id);
        return new PostDto(
                Math.toIntExact(postEntity.getId()),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getWriter(),
                postEntity.getBoardEntity() == null
                        ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
        );
    }

    public List<PostDto> readPostAll(){
        Iterator<PostEntity> iterator = this.postDao.readPostAll();
        List<PostDto> postDtoList = new ArrayList<>();
        while(iterator.hasNext()){
            PostEntity postEntity = iterator.next(); // hasNext가 false가 안되면 컴터가 터진다고...?
            postDtoList.add(new PostDto(
                    Math.toIntExact(postEntity.getId()),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getWriter(),
                    postEntity.getBoardEntity() == null
                            ? 0 : Math.toIntExact(postEntity.getBoardEntity().getId())
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
