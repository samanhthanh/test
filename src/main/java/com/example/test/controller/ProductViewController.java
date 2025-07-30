package com.example.test.controller;

import com.example.test.dto.response.ProductDTO;
import com.example.test.dto.response.ProductResponse;
import com.example.test.exceptions.APIException;
import com.example.test.security.services.UserDetailsImpl;
import com.example.test.services.ProductViewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductViewController {

    @Autowired
    ProductViewService productViewService;

    @GetMapping("/public/products")
    public ResponseEntity<?> getAllProducts(
            @RequestParam(name = "productName", required = false) String productName,
            @RequestParam(name = "minPrice", required = false) Double minPrice,
            @RequestParam(name = "maxPrice", required = false) Double maxPrice,
            Pageable pageable
    ) {
        return new ResponseEntity<>(productViewService.getAllProducts(productName, minPrice, maxPrice, pageable), HttpStatus.OK);
    }

    @PostMapping("/admin/product")
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO,
                                                 Authentication authentication){
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//        boolean checkRole = false;
//        for (String role : roles) {
//            if (role.equals("ROLE_ADMIN")) {
//                checkRole = true;
//            }
//        }
//        if (!checkRole) {
//           throw new APIException("not permitted");
//        }
        return new ResponseEntity<>(productViewService.addProduct(productDTO), HttpStatus.CREATED);
    }
}
