package ru.breadwinner.service.property;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.category.Category;
import ru.breadwinner.service.common.BaseDAO;
import ru.breadwinner.service.common.EntityNotFountException;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PropertyDAO implements BaseDAO<Property> {

    private final PropertyRepository propertyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Property getById(int id) {
        return propertyRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFountException("Дополнительное свойство с идентификатором %d не найдено", id));
    }

    @Transactional
    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Transactional
    @Override
    public void delete(Property property) {
        propertyRepository.delete(property);
    }

    @Transactional(readOnly = true)
    public List<Property> getAllByCategory(Category category) {
        return propertyRepository.findAllByCategory(category);
    }
}
