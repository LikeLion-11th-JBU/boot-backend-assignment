package dev.likelion.auth.entity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <UserEntity, Long> {
    UserEntity fineByUserName(String username);

}
