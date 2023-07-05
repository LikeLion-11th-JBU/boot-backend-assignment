package dev.park.crud.crud.post;

import java.util.List;
//데이터회수
public interface PostRepository {
    List<PostDto> findAll();
    PostDto findById(int id);
    boolean save(PostDto dto);
    boolean delete(int id);
    boolean update(int id, PostDto dto);
}
