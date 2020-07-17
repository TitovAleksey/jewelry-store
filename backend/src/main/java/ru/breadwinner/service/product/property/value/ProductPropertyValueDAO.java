package ru.breadwinner.service.product.property.value;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.common.BaseDAO;
import ru.breadwinner.service.common.EntityNotFountException;
import ru.breadwinner.service.product.Product;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductPropertyValueDAO implements BaseDAO<ProductPropertyValue> {

    private final ProductPropertyValueRepository repository;

    @Override
    public List<ProductPropertyValue> getAll() {
        throw new UnsupportedOperationException();
    }

    @Transactional(readOnly = true)
    public List<ProductPropertyValue> getAllByProduct(Product product) {
        return repository.findAllByProduct(product);
    }

    @Transactional
    @Override
    public ProductPropertyValue getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFountException("Товар с идентификатором %d не найден", id));
    }

    @Transactional
    @Override
    public ProductPropertyValue save(ProductPropertyValue entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public void delete(ProductPropertyValue entity) {
        repository.delete(entity);
    }
}
