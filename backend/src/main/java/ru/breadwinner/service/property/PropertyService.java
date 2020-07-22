package ru.breadwinner.service.property;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.property.type.PropertyType;
import ru.breadwinner.service.property.type.PropertyTypeDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PropertyService {

    private final PropertyDAO propertyDAO;
    private final ConversionService conversionService;

    public List<PropertyTypeDTO> getTypes() {
        return Arrays.stream(PropertyType.values())
                .map(PropertyTypeDTO::new)
                .collect(Collectors.toList());
    }

    public List<PropertyDTO> getAll() {
        return propertyDAO.getAll().stream()
                .map(this::convertProperty)
                .collect(Collectors.toList());
    }

    private PropertyDTO convertProperty(Property source) {
        return conversionService.convert(source, PropertyDTO.class);
    }

    public PropertyDTO getById(int id) {
        Property property = propertyDAO.getById(id);
        return convertProperty(property);
    }

    public PropertyDTO add(PropertyEditDTO request) {
        Property property = new Property();
        fillProperty(property, request);
        property = propertyDAO.save(property);
        return convertProperty(property);
    }

    private void fillProperty(Property property, PropertyEditDTO source) {
        property.setName(source.getName())
                .setType(source.getType())
                .setHidden(source.getIsHidden())
                .setUseInFilter(source.getIsHidden());
    }

    @Transactional
    public PropertyDTO update(int id, PropertyEditDTO request) {
        //TODO: при смене типа дополнительного свойства удалять допустимые и заполненные значения
        Property property = propertyDAO.getById(id);
        fillProperty(property, request);
        property = propertyDAO.save(property);
        return convertProperty(property);
    }

    @Transactional
    public void delete(int id) {
        //TODO: удаление допустимых и заполненных значений
        Property property = propertyDAO.getById(id);
        propertyDAO.delete(property);
    }
}
