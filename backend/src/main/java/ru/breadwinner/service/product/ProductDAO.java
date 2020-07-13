package ru.breadwinner.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.common.BaseDAO;
import ru.breadwinner.service.common.EntityNotFountException;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductDAO implements BaseDAO<Product> {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Product getById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFountException("Товар с идентификатором %d не найден", id));
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }
}
