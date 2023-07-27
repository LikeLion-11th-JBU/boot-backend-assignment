package dev.park.crud.crud.post;

import java.util.List;
//데이터 검증
public interface PostService {
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);
}
