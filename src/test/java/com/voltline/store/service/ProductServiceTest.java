package com.voltline.store.service;

import com.voltline.store.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void findAll_ShouldReturnSeededProducts() {
        List<Product> products = productService.findAll();
        assertNotNull(products);
        assertEquals(6, products.size());
    }

    @Test
    void findById_ShouldReturnCorrectProduct() {
        Optional<Product> product = productService.findById(1L);
        assertTrue(product.isPresent());
        assertEquals("Gaming Laptop", product.get().name());
    }

    @Test
    void findById_ShouldReturnEmptyForNonExistentId() {
        Optional<Product> product = productService.findById(99L);
        assertTrue(product.isEmpty());
    }
}
