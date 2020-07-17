package ru.breadwinner.service.product.property.value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.breadwinner.service.product.Product;

import java.util.List;

@Repository
public interface ProductPropertyValueRepository extends JpaRepository<ProductPropertyValue, Integer> {

    List<ProductPropertyValue> findAllByProduct(Product product);
}
