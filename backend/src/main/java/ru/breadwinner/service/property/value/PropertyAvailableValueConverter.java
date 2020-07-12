package ru.breadwinner.service.property.value;

import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseConverter;

@Component
public class PropertyAvailableValueConverter extends BaseConverter<PropertyAvailableValue, PropertyAvailableValueDTO> {

    @Override
    protected PropertyAvailableValueDTO convertInternal(PropertyAvailableValue source) {
        return PropertyAvailableValueDTO.builder()
                .id(source.getId())
                .value(source.getValue())
                .build();
    }
}
