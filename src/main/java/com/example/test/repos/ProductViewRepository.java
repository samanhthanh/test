package com.example.test.repos;

import com.example.test.entities.ProductView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductViewRepository extends JpaRepository<ProductView, Long> {

    @Query("""
                SELECT p FROM ProductView p
                WHERE (:minPrice IS NULL OR p.price >= :minPrice)
                  AND (:maxPrice IS NULL OR p.price <= :maxPrice)
                  AND (:productName IS NULL OR LOWER(p.productName) LIKE LOWER(CONCAT('%', :productName, '%')))
            """)
    Page<ProductView> findByFilter(@Param("productName") String productName,
                                   @Param("minPrice") Double minPrice,
                                   @Param("maxPrice") Double maxPrice,
                                   Pageable pageable);
}
