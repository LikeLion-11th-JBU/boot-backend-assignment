package dev.aquashdw.crud.post;

import java.util.List;
// Repository 어노테이션은 데이터베이스를 소통을 한다라는 부분이 있다. -> 데이터를 실제로 주고받는 파트를 만들 때 사용한다.
public interface PostRepository {
    List<PostDto> findAll();
    PostDto findById(int id);   // id를 주면 PostDto가 돌아와야한다.
    boolean save(PostDto dto);
    boolean delete(int id);
    boolean update(int id,PostDto dto);
    // 이렇게 하면 PostRepository 는 이 뒤가 어떻게 구현이 되어 있던지 상관없이 이 인터페이스 자체는 어떠한 데이터를 조회해 줄것이고, 어떠한 PostDto를 다루기 위한 인터페이스라는 것을 볼 수 있다.
}
