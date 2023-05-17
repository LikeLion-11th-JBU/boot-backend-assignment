package dev.Sung.mybais;

import dev.Sung.mybais.dao.PostDao;
import dev.Sung.mybais.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestComponent {
    private final PostDao postDao;
    public TestComponent(
            @Autowired PostDao postDao
    ){
        this.postDao = postDao;
        PostDto newPost = new PostDto();
        newPost.setTitle("From Mybatis");
        newPost.setContent("Use Database wiht Spring Boot!");
        newPost.setWriter("asd");
        newPost.setBoard(1);
        this.postDao.createPost(newPost);

        List<PostDto> postDtoList = this.postDao.readPostAll();
        System.out.println(postDtoList.size() - 1);

        PostDto firstPost = postDtoList.get(0);
        firstPost.setContent("content Update From Mybatis!");
        postDao.updatePost(firstPost);

        System.out.println(this.postDao.readPost(firstPost.getId()));

    }
}
