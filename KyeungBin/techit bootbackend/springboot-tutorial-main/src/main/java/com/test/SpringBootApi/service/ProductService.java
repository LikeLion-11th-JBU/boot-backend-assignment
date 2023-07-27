package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;

import java.util.Optional;

public interface ProductService {

    public Product save(Product product); //
    public Optional<Product> findById(Long id); // 없는 값 (NULL)을 검색했을 때의 대응?
    public Product update(Long id, Product product); // 고유한 Id값의 개체를 찾고 새로운 product의 값으로 덮어쓰게 함
    public void delete(Long id); // 수정한 Id값을 삭제??

}
