import com.example.mybatis.dao.BoardDao;
import com.example.mybatis.dao.PostDao;
import com.example.mybatis.dto.BoardDto;
import com.example.mybatis.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestComponent {
    private final PostDao postDao;
    private final BoardDao boardDao;

    public TestComponent(
            @Autowired PostDao postDao,
            @Autowired BoardDao boardDao
    ){
        this.postDao = postDao;
        this.boardDao = boardDao;

        BoardDto boardDto = new BoardDto();
        boardDto.setName("new board");
        // 보드 이름을 new board로
        this.boardDao.createBoard(boardDto);
        System.out.println(boardDto.getId());

//        this.postDao = postDao;
//        PostDto newPost = new PostDto();
//        newPost.setTitle("From Mybatis");
//        newPost.setContent("Use Database with Spring Boot!");
//        newPost.setWriter("example");
//        newPost.setBoard(1);
//        this.postDao.createPost(newPost);
//
//        List<PostDto> postDtoList = this.postDao.readPostAll();
//        System.out.println(postDtoList.get(postDtoList.size() - 1));
//
//        PostDto firstPost = postDtoList.get(0);
//        firstPost.setContent("Content Updated From Mybatis!");
//        postDao.updatePost(firstPost);
//
//        System.out.println(this.postDao.readPost(firstPost.getId()));

    }

}
