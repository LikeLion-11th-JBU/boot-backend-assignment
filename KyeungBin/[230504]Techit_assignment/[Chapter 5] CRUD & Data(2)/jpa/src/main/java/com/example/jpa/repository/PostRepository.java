package com.example.jpa.repository;

import com.example.jpa.entity.BoardEntity;
import com.example.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);
    // where writer = ? (무엇으로 가게될지)
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity);
    // where writer =? and board_entity_id = ? , writer의 내용과 board_entity_id를 함께 가지고 있는 포스트 검색?
    List<PostEntity> findAllByWriterContaining(String writer);
    // writer의 내용을 포함하는 내용을 기준으로 검색
    
    /*
    저 findAllBy~ , findAllBy~And@ , findAllBy~Containing 전부 검색해보기 (SQL이랑 친해지면 개꿀이다)
    엌ㅋㅋㅋ 근데 jpa를 나중에 하셧네 
     */
}
