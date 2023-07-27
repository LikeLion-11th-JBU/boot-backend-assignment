package dev.park.jpa.repository;

import dev.park.jpa.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

}
