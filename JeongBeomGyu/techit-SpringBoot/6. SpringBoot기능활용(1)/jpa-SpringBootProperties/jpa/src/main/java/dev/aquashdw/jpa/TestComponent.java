package dev.aquashdw.jpa;

import dev.aquashdw.jpa.entity.BoardEntity;
import dev.aquashdw.jpa.entity.PostEntity;
import dev.aquashdw.jpa.repository.BoardRepository;
import dev.aquashdw.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TestComponent {
    public TestComponent(
            @Autowired BoardRepository boardRepository,
            @Autowired PostRepository postRepository
            ){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("hello ORM");
        postEntity.setContent("This Entity is created by hibernate!");
        postEntity.setWriter("aquashdw");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("aquashdw").size());      // findAll -> 모든 것을 찾아라 writer가 aquashdw인 것으로 -> 위에 setwriter를 통해서 하나 넣어줬으니까 하나가 존재할 것이다.
    }
}
