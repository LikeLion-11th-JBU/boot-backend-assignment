package dev.SeungIL.community.repository;

import dev.SeungIL.community.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
