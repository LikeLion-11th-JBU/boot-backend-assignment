//package dev.likelion.jpa;
//
//import dev.likelion.jpa.entity.BoardEntity;
//import dev.likelion.jpa.entity.PostEntity;
//import dev.likelion.jpa.repository.BoardRepository;
//import dev.likelion.jpa.repository.PostRepository;
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
////        System.out.println(newBoardEntity.getName());
//
//        PostEntity postEntity = new PostEntity();
//        postEntity.setTitle("hello ORM");
//        postEntity.setContent("This Entity is created by hibernate!");
//        postEntity.setWriter("likelion");
//        postEntity.setBoardEntity(newBoardEntity);
//        PostEntity newPostEntity = postRepository.save(postEntity);
//
////        System.out.println(postRepository.findAllByWriter("likelion").size());
//
//    }
//}
