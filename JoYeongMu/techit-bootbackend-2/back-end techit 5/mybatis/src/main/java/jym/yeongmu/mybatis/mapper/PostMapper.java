package jym.yeongmu.mybatis.mapper;

import jym.yeongmu.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);
    PostDto readPost(int id);
    PostDto readPosot(int id);
    List<PostDto> readPostAll();
    int updatePost(PostDto dto);
    int deletePost(int id);
}
