package dev.aquashdw.mybatis.mapper;

import dev.aquashdw.mybatis.dto.PostDto;

import java.util.List;

public interface PostMapper {
    int createPost(PostDto dto);      //PostMapper라는 인터페이스에 post-mapper.xml의 insert문에 createPost라는 id를 가진 이 insert문을 연결해주기 위해서 PostMapper 인터페이스에다가 void createPost()라고 작성을한다
                                      //그리고 post-mapper.xml에서 parameterType으로 지정해 놓은 "dev.aquashdw.mybatis.dto.PostDto"은 void createPost가 받아들일 파라미터 타입을 의미한다.
                                      // int를 쓰는 이유는  insert update delete 문의 경우에 int를 쓴다. 이 경우에는 결과로서 몇 개의 row가 조작을 받았는지를 결과로 돌려주게 되는데, 그 때 몇 개의 Row냐가 int로서 return으로 돌아오기 때문에 int라고 해준다.
    int createPostAll(List<PostDto> dtoList);
    PostDto readPost(int id);
    List<PostDto> readPostAll();
    PostDto readPostQuery(PostDto dto);
    int updatePost(PostDto dto);
    int deletePost(int id);


}
