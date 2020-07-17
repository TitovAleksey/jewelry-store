package ru.breadwinner.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.common.BaseDAO;
import ru.breadwinner.service.common.EntityNotFountException;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductDAO implements BaseDAO<Product> {

    private final ProductRepository repository;

    @Override
    public List<Product> getAll() {
        throw new UnsupportedOperationException();
    }

    @Transactional(readOnly = true)
    public Page<Product> getAll(int pageNumber, int pageSize) {
        return repository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Transactional(readOnly = true)
    @Override
    public Product getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFountException("Товар с идентификатором %d не найден", id));
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        repository.delete(product);
    }
}
