package com.test.SpringBootApi.service;

import com.test.SpringBootApi.domain.Product;
import com.test.SpringBootApi.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired //
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {

        try {
            return productRepository.save(
                    new Product(
                            product.getProductName(),
                            product.getPrice()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Optional<Product> findById(Long id) {

        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                return productData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Long id, Product product) {

        try {
            Optional<Product> productData = productRepository.findById(id);
            if (productData.isPresent()) {
                Product _product = productData.get(); // 새로운 값을 받아서 덮어쓰는 데이터를 의미.
                _product.setProductName(product.getProductName());
                _product.setPrice(product.getPrice());
                productRepository.save(_product);
                return _product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void delete(Long id) {

        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
