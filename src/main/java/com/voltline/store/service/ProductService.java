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
            new Product(1L, "Gaming Laptop", "High performance gaming laptop", new BigDecimal("1999.99")),
            new Product(2L, "Dell XPS 13", "Compact and powerful laptop", new BigDecimal("1299.00")),
            new Product(3L, "Sony WH-1000XM5", "Industry leading noise canceling headphones", new BigDecimal("398.00")),
            new Product(4L, "Logitech MX Master 3S", "Ergonomic wireless mouse", new BigDecimal("99.00")),
            new Product(5L, "Samsung Odyssey G9", "Ultra-wide curved gaming monitor", new BigDecimal("1499.99")),
            new Product(6L, "Keychron Q1", "Mechanical keyboard", new BigDecimal("169.00"))
        );
        initialProducts.forEach(p -> products.put(p.id(), p));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Product save(Product product) {
        Long id = product.id();
        if (id == null) {
            id = System.currentTimeMillis();
            product = new Product(id, product.name(), product.description(), product.price());
        }
        products.put(id, product);
        return product;
    }

    public boolean deleteById(Long id) {
        return products.remove(id) != null;
    }
}
