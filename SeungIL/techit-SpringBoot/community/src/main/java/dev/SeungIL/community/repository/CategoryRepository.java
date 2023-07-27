package dev.SeungIL.community.repository;

import dev.SeungIL.community.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}