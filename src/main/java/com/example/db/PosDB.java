package com.example.db;

import com.example.model.Product;

import java.util.List;

public interface PosDB {
    public List<Product> getProducts();

    public Product getProduct(String productId);
}
