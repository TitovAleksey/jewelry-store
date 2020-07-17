package ru.breadwinner.service.product.property.value;

import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseConverter;

@Component
public class ProductPropertyValueConverter extends BaseConverter<ProductPropertyValue, ProductPropertyValueDTO> {

    @Override
    protected ProductPropertyValueDTO convertInternal(ProductPropertyValue source) {
        return ProductPropertyValueDTO.builder()
                .propertyId(source.getProperty().getId())
                .textValue(source.getTextValue())
                .numberValue(source.getNumberValue())
                .dictionaryValueId(source.getDictionaryValue() == null ? null :
                        source.getDictionaryValue().getId())
                .build();
    }
}
