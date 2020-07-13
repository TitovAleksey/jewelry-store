package ru.breadwinner.service.category;

import org.springframework.stereotype.Component;
import ru.breadwinner.service.common.BaseConverter;

@Component
public class CategoryConverter extends BaseConverter<Category, CategoryDTO> {

    @Override
    protected CategoryDTO convertInternal(Category source) {
        return CategoryDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .sort(source.getSort())
                .isHidden(source.isHidden())
                .productLayoutTemplate(source.getProductLayoutTemplate())
                .build();
    }
}
