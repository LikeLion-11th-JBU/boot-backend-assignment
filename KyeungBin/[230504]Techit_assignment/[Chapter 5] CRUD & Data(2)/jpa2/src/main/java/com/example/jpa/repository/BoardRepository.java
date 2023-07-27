package com.example.jpa.repository;

import com.example.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
    // < 이 레포지토리가 어떤 엔티티를 위한 것인지, id가 어떤 타입으로 작성이 되는지>
    // CRUD작업을 하기 위한 레포지토리를 위한 인터페이스
}
