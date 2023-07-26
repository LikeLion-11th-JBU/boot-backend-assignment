package dev.aquashdw.crud.post;

import java.util.List;

// Service는 실행하기 전에 비지니스 로직 또는 여러가지 실행 결과들을 조합할 때 사용한다.
public interface PostService {  // 중요한 점은 엔트포인트(컨트롤러 부분), 모델, 데이터베이스 부분 그리고 비지니스 로직을 분리하는 것을 목적으로 하고 있다.
    void createPost(PostDto dto);
    List<PostDto> readPostAll();
    PostDto readPost(int id);
    void updatePost(int id, PostDto dto);
    void deletePost(int id);

    // 지금은 Repository와 Service가 간단하지만 나중에는 Service가 단순히 CRUD뿐만아니라 Check 뿐만 아니라, 현재 요청을 보낸 사용자가 read를 할 때 이것을 읽을 권한이 있는지 없는지에 대해 측정을 해야하는 상황도 Service에 구현이 된다. Date를 회수하는 역할은 Repository에서 한다. 회수된 데이터를 비교해서 사용가능한 데이터인지를 확인하는 것은 Service에서 한다.
}
