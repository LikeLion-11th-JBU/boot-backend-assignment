package dev.SeungIL.jpa.repository;

import dev.SeungIL.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

}
