package ru.breadwinner.service.product;

import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseConverter;

@Component
public class ProductConverter extends BaseConverter<Product, ProductDTO> {

    @Override
    protected ProductDTO convertInternal(Product source) {
        return ProductDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .isHidden(source.isHidden())
                .build();
    }
}
