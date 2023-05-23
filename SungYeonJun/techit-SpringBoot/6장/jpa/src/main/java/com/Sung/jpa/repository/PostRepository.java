package com.Sung.jpa.repository;

import com.Sung.jpa.entity.BoardEntity;
import com.Sung.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    List<PostEntity> findAllByWriter(String writer);    // where문에서 where writer = ?의 형태로 작성
    List<PostEntity> findAllByWriterAndBoardEntity(String writer, BoardEntity boardEntity); // where writer = ? and board_entity_id = ?
    List<PostEntity> findAllByWriterContaining(String writer);
}