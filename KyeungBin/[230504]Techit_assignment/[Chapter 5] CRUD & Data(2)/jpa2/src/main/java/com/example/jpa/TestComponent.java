package com.example.jpa;

import com.example.jpa.entity.BoardEntity;
import com.example.jpa.entity.PostEntity;
import com.example.jpa.repository.BoardRepository;
import com.example.jpa.repository.PostRepository;
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
        // 여기부분 설명 무슨소리지? 5-3 ☆22분~23분 17초☆
        System.out.println(newBoardEntity.getName());

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("hello, OMG!");
        postEntity.setContent("This Entity is created by hibernate");
        postEntity.setWriter("Nada");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("Nada").size());

    }
}
