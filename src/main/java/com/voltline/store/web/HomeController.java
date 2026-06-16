package com.voltline.store.web;

import com.voltline.store.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<Product> products = Arrays.asList(
            new Product(1L, "Voltline Pro Laptop", new BigDecimal("1299.99"), "Computers"),
            new Product(2L, "Voltline Noise-Cancelling Headphones", new BigDecimal("249.50"), "Audio"),
            new Product(3L, "Voltline Smartwatch Series X", new BigDecimal("399.00"), "Wearables"),
            new Product(4L, "Voltline Mechanical Keyboard", new BigDecimal("120.00"), "Accessories")
        );
        
        model.addAttribute("products", products);
        return "home";
    }
}
