package ru.breadwinner.service.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseDAO;
import ru.breadwinner.service.common.EntityNotFountException;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CategoryDAO implements BaseDAO<Category> {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFountException("Категория с идентификатором %d не найдена", id));
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
