package ru.breadwinner.service.property;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.common.EntityNotFountException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final ConversionService conversionService;

    @Transactional(readOnly = true)
    public List<PropertyDTO> getAll() {
        return propertyRepository.findAll().stream()
                .map(this::convertProperty)
                .collect(Collectors.toList());
    }

    private PropertyDTO convertProperty(Property source) {
        return conversionService.convert(source, PropertyDTO.class);
    }

    @Transactional(readOnly = true)
    public PropertyDTO getById(int id) {
        Property property = getPropertyById(id);
        return convertProperty(property);
    }

    private Property getPropertyById(int id) {
        return propertyRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFountException("Дополнительное свойство с идентификатором %d не найдено", id));
    }

    @Transactional
    public PropertyDTO add(PropertyEditDTO request) {
        Property property = new Property();
        fillProperty(property, request);
        propertyRepository.save(property);
        return convertProperty(property);
    }

    private void fillProperty(Property property, PropertyEditDTO source) {
        property.setName(source.getName())
                .setType(source.getType())
                .setHidden(source.isHidden())
                .setUseInFilter(source.isUseInFilter());
    }

    @Transactional
    public PropertyDTO update(int id, PropertyEditDTO request) {
        //TODO: при смене типа дополнительного свойства удалять допустимые и заполненные значения
        Property property = getPropertyById(id);
        fillProperty(property, request);
        propertyRepository.save(property);
        return convertProperty(property);
    }

    @Transactional
    public void delete(int id) {
        //TODO: удаление допустимых и заполненных значений
        Property property = getPropertyById(id);
        propertyRepository.delete(property);
    }
}
