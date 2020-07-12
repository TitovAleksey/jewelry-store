package ru.breadwinner.service.property.value;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.breadwinner.service.common.EntityNotFountException;
import ru.breadwinner.service.property.Property;
import ru.breadwinner.service.property.PropertyRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PropertyAvailableValueService {

    private final PropertyRepository propertyRepository;
    private final PropertyAvailableValueRepository propertyAvailableValueRepository;
    private final ConversionService conversionService;

    @Transactional(readOnly = true)
    public List<PropertyAvailableValueDTO> getAllByProperty(int propertyId) {
        Property property = getProperty(propertyId);
        return propertyAvailableValueRepository.findAllByProperty(property).stream()
                .map(this::convertPropertyAvailableValue)
                .collect(Collectors.toList());
    }

    private Property getProperty(int propertyId) {
        return propertyRepository.findById(propertyId)
                .orElseThrow(() -> new EntityNotFountException("Дополнительное свойство с идентификатором %d не найдено",
                        propertyId));
    }

    private PropertyAvailableValueDTO convertPropertyAvailableValue(PropertyAvailableValue source) {
        return conversionService.convert(source, PropertyAvailableValueDTO.class);
    }

    @Transactional(readOnly = true)
    public PropertyAvailableValueDTO getByPropertyAndId(int propertyId, int valueId) {
        PropertyAvailableValue propertyAvailableValue = getPropertyAvailableValueByPropertyAndId(propertyId, valueId);
        return convertPropertyAvailableValue(propertyAvailableValue);
    }

    private PropertyAvailableValue getPropertyAvailableValueByPropertyAndId(int propertyId, int valueId) {
        Property property = getProperty(propertyId);
        return propertyAvailableValueRepository.findByPropertyAndId(property, valueId)
                .orElseThrow(() -> new EntityNotFountException("Значение дополнительного свойства по идентификатору %d " +
                        "не найдено", valueId));
    }

    @Transactional
    public PropertyAvailableValueDTO add(int propertyId, PropertyAvailableValueEditDTO request) {
        Property property = getProperty(propertyId);

        PropertyAvailableValue propertyAvailableValue = new PropertyAvailableValue();
        propertyAvailableValue.setProperty(property);
        fillPropertyAvailableValue(propertyAvailableValue, request);

        propertyAvailableValueRepository.save(propertyAvailableValue);
        return convertPropertyAvailableValue(propertyAvailableValue);
    }

    private void fillPropertyAvailableValue(PropertyAvailableValue propertyAvailableValue,
                                            PropertyAvailableValueEditDTO source) {
        propertyAvailableValue.setValue(source.getValue());
    }

    @Transactional
    public PropertyAvailableValueDTO update(int propertyId, int valueId, PropertyAvailableValueEditDTO request) {
        PropertyAvailableValue propertyAvailableValue = getPropertyAvailableValueByPropertyAndId(propertyId, valueId);
        fillPropertyAvailableValue(propertyAvailableValue, request);

        propertyAvailableValueRepository.save(propertyAvailableValue);
        return convertPropertyAvailableValue(propertyAvailableValue);
    }

    @Transactional
    public void deleteByPropertyAndId(int propertyId, int valueId) {
        //TODO: отвязка удаляемого значения от товаров
        PropertyAvailableValue propertyAvailableValue = getPropertyAvailableValueByPropertyAndId(propertyId, valueId);
        propertyAvailableValueRepository.delete(propertyAvailableValue);
    }
}
