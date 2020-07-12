package ru.breadwinner.service.property;

import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseConverter;

@Component
public class PropertyConverter extends BaseConverter<Property, PropertyDTO> {

    @Override
    protected PropertyDTO convertInternal(Property source) {
        return PropertyDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .type(source.getType())
                .isHidden(source.isHidden())
                .isUseInFilter(source.isUseInFilter())
                .build();
    }
}
