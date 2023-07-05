package jym.yeongmu.CRUD.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryInMemory implements PostRepository{
    private static final Logger logger = LoggerFactory.getLogger(PostRepository.class);
    private final List<PostDto> postList;

    public PostRepositoryInMemory() {
        this.postList = new ArrayList<>();
    }

    @Override
    public boolean save(PostDto dto) {
        return this.postList.add(dto);
    }

    @Override
    public List<PostDto> findAll() {
        return this.postList;
    }

    @Override
    public PostDto findById(int id) {
        return this.postList.get(id);
    }



    @Override
    public boolean update(int id, PostDto postDto) {
        PostDto targerPost = this.postList.get(id);
        if (postDto.getTitle() != null) {
            targerPost.setTitle(postDto.getTitle());
        }
        if (postDto.getContent() != null) {
            targerPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targerPost);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.postList.remove(id);
        return true;
    }
}
