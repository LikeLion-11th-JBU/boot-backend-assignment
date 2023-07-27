package com.test.SpringBootApi.respository;

import com.test.SpringBootApi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 데이터베이스와 가장 가깝다
public interface ProductRepository extends JpaRepository<Product, Long> {



}
