package com.likelion.CRUD.Post;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PostServiceSimple implements PostService {
    private final PostRepository postRepository;

    public PostServiceSimple(
            @Autowired PostRepository postRepository
    ){
        this.postRepository = postRepository;
    }

    @Override
    public void createPost(PostDto dto) {
        // TODO
        if (!this.postRepository.save(dto)) {
            throw new RuntimeException("save failed");
        }
    }

    @Override
    public List<PostDto> readPostAll() {
        return this.postRepository.findAll();
    }

    @Override
    public PostDto readPost(int id) {
        return this.postRepository.findById(id);
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