package com.example.test.services.impl;

import com.example.test.dto.response.ProductDTO;
import com.example.test.dto.response.ProductResponse;
import com.example.test.entities.ProductView;
import com.example.test.repos.ProductViewRepository;
import com.example.test.services.ProductViewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductViewServiceImpl implements ProductViewService {

    @Autowired
    ProductViewRepository productViewRepository;

    @Override
    public Page<?> getAllProducts(String productName, Double minPrice, Double maxPrice, Pageable pageable) {
        Page<ProductView> data = productViewRepository.findByFilter(productName, minPrice, maxPrice, pageable);
        List<ProductView> productViews = data.getContent();
        List<ProductDTO> products = productViews.stream().map(productView -> {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productView, productDTO);
            return productDTO;
        }).toList();

        return new PageImpl<>(productViews, pageable, data.getTotalPages());
    }

    @Override
    public String addProduct(ProductDTO productDTO) {
        ProductView productView = new ProductView();
        BeanUtils.copyProperties(productDTO, productView);
        productViewRepository.save(productView);
        return "Done";
    }
}
