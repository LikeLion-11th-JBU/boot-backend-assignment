//package dev.park.jpa;
//
//import dev.park.jpa.entity.BoardEntity;
//import dev.park.jpa.entity.PostEntity;
//import dev.park.jpa.repository.BoardRepository;
//import dev.park.jpa.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TestComponent {
//    public TestComponent(
//            @Autowired BoardRepository boardRepository,
//            @Autowired PostRepository postRepository
//            ){
//        BoardEntity boardEntity = new BoardEntity();
//        boardEntity.setName("new board");
//        BoardEntity newBoardEntity = boardRepository.save(boardEntity);
//
//        PostEntity postEntity = new PostEntity();
//        postEntity.setTitle("hello ORM");
//        postEntity.setContent("First Hibernate Entity");
//        postEntity.setWriter("park");
//        postEntity.setBoardEntity(newBoardEntity);
//        PostEntity newPostEntity = postRepository.save(postEntity);
//
//    }
//}
