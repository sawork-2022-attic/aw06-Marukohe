package com.example.webpos.db;

import com.example.webpos.model.Product;
import com.example.webpos.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AmazonDB implements PosDB{
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
//        logger.info("GET PRODUCTS");
        List<Product> products = new ArrayList<>();
        productRepository.findAll(PageRequest.of(1, 100)).forEach(
            product -> {
                if (product.getPrice() > 0) {
//                    logger.info(product.toString());
                    products.add(product);
                }
            }
        );
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
