package com.voltline.store.service;

import com.voltline.store.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>(List.of(
        new Product(1L, "Gaming Laptop", "High-performance laptop for gaming", new BigDecimal("1299.99")),
        new Product(2L, "Mechanical Keyboard", "RGB backlit mechanical keyboard", new BigDecimal("89.50")),
        new Product(3L, "Wireless Mouse", "Ergonomic wireless mouse", new BigDecimal("45.00")),
        new Product(4L, "4K Monitor", "32-inch 4K UHD monitor", new BigDecimal("349.99")),
        new Product(5L, "Noise Cancelling Headphones", "Active noise cancelling over-ear headphones", new BigDecimal("199.00")),
        new Product(6L, "USB-C Hub", "Multi-port USB-C adapter", new BigDecimal("29.99"))
    ));

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream()
                .filter(p -> p.id().equals(id))
                .findFirst();
    }
}
