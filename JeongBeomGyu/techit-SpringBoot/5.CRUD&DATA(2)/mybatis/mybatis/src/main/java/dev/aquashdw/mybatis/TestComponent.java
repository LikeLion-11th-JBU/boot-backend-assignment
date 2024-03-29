package dev.aquashdw.mybatis;

import dev.aquashdw.mybatis.dao.BoardDao;
import dev.aquashdw.mybatis.dao.PostDao;
import dev.aquashdw.mybatis.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;
    public TestComponent(
            @Autowired PostDao postDao,
            @Autowired BoardDao boardDao,
            BoardDao boardDao1){
        this.postDao = postDao;
        this.boardDao = boardDao;
        BoardDto boardDto = new BoardDto();     // BoardDto를 만들어서
        boardDto.setName("new board");          // setName을 통해서 이름을 주고
        this.boardDao.createBoard(boardDto);        //createBoard를 했더니
        System.out.println(boardDto.getId());       // setId로 id를 정의하지 않아도 createBoard를 하면 getId를 했을 때 그 값이 나온다. 이것은 useGeneratedKeys와 keyProperty에서 해주는 것인데 useGeneratedKey가 true가 되었을 때 DB에서 만들어준 id값 AutoGeneratedKey를 바로 활용을 하겠다는 옵션값이다. 그 중에서도 KeyProperty는 어떠한 것에다가 그 id값을 채워줄 것이냐를 지정해준다.
//        PostDto newPost = new PostDto();
//        newPost.setTitle("From Mybatis");
//        newPost.setContent("Hello Database");
//        newPost.setWriter("aquashdw");
//        newPost.setBoardId(1);
//
//        List<PostDto> postDtoList = this.postDao.readPostAll();
//        System.out.println(postDtoList.get(postDtoList.size() -1));
//
//        PostDto firstPost = postDtoList.get(0);
//        firstPost.setContent("Update From Mybatis");
//        postDao.updatePost(firstPost);
//
//        System.out.println(this.postDao.readPost(firstPost.getId()));
    }
}
