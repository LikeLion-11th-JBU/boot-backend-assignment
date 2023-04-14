package com.test.SpringBootApi.domain;

import javax.persistence.*;

@Entity // 어노테이션?
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 숫자가 자동으로 하나씩 증가하도록.
    private Long id;

    @Column(name = "product_name") // 항목에 관한 어노테이션
    private String productName;

    @Column(name = "price")
    private int price;

    public Product() {}

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
