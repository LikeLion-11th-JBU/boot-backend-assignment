package dev.SeungIL.jpa.repository;

import dev.SeungIL.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}