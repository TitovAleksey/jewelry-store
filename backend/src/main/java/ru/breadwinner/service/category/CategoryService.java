package ru.breadwinner.service.category;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.breadwinner.service.property.Property;
import ru.breadwinner.service.property.PropertyDAO;
import ru.breadwinner.service.property.PropertyDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryDAO categoryDAO;
    private final PropertyDAO propertyDAO;
    private final ConversionService conversionService;

    public List<CategoryDTO> getAll() {
        return categoryDAO.getAll().stream()
                .map(this::convertCategory)
                .collect(Collectors.toList());
    }

    private CategoryDTO convertCategory(Category source) {
        return conversionService.convert(source, CategoryDTO.class);
    }

    public CategoryDTO getById(int id) {
        Category category = categoryDAO.getById(id);
        return convertCategory(category);
    }

    public CategoryDTO add(CategoryEditDTO request) {
        Category category = new Category();
        fillCategory(category, request);
        categoryDAO.save(category);
        return convertCategory(category);
    }

    private void fillCategory(Category category, CategoryEditDTO source) {
        category.setName(source.getName())
                .setSort(source.getSort())
                .setHidden(source.getIsHidden())
                .setProductLayoutTemplate(source.getProductLayoutTemplate())
                .setProperties(source.getPropertyIds() == null || source.getPropertyIds().isEmpty() ? Collections.emptySet() :
                        source.getPropertyIds().stream()
                                .map(propertyDAO::getById)
                                .collect(Collectors.toSet()));
    }

    public CategoryDTO update(int id, CategoryEditDTO request) {
        Category category = categoryDAO.getById(id);
        fillCategory(category, request);
        categoryDAO.save(category);
        return convertCategory(category);
    }

    public void delete(int id) {
        //TODO: при удалении удалять все связанные сущности
        Category category = categoryDAO.getById(id);
        categoryDAO.delete(category);
    }

    public List<PropertyDTO> getPropertiesByCategory(int categoryId) {
        Category category = categoryDAO.getById(categoryId);
        return propertyDAO.getAllByCategory(category).stream()
                .map(this::convertProperty)
                .collect(Collectors.toList());
    }

    private PropertyDTO convertProperty(Property source) {
        return conversionService.convert(source, PropertyDTO.class);
    }
}

