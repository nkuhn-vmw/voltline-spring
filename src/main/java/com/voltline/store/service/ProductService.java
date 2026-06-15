package com.voltline.store.service;

import com.voltline.store.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {
    private final Map<Long, Product> products = new ConcurrentHashMap<>();

    public ProductService() {
        seedProducts();
    }

    private void seedProducts() {
        List<Product> initialProducts = Arrays.asList(
            new Product(1L, "Gaming Laptop", new BigDecimal("1999.99"), "Laptops"),
            new Product(2L, "Dell XPS 13", new BigDecimal("1299.00"), "Laptops"),
            new Product(3L, "Sony WH-1000XM5", new BigDecimal("398.00"), "Audio"),
            new Product(4L, "Logitech MX Master 3S", new BigDecimal("99.00"), "Peripherals"),
            new Product(5L, "Samsung Odyssey G9", new BigDecimal("1499.99"), "Monitors"),
            new Product(6L, "Keychron Q1", new BigDecimal("169.00"), "Peripherals")
        );
        initialProducts.forEach(p -> products.put(p.getId(), p));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Product save(Product product) {
        Long id = product.getId();
        if (id == null) {
            id = System.currentTimeMillis();
            product.setId(id);
        }
        products.put(id, product);
        return product;
    }

    public boolean deleteById(Long id) {
        return products.remove(id) != null;
    }
}
