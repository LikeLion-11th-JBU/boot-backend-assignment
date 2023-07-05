package dev.SeungIL.community.repository;

import dev.SeungIL.community.entity.ShopReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}