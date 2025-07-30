package com.example.test.services;

import com.example.test.dto.response.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductViewService {
    Page<?> getAllProducts(String productName, Double minPrice, Double maxPrice, Pageable pageable);

    String addProduct(@Valid ProductDTO productDTO);
}
