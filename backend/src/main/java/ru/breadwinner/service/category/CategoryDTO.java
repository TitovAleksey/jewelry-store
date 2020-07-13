package ru.breadwinner.service.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Категория")
@Builder
@Getter
public class CategoryDTO {

    @ApiModelProperty("Идентификатор")
    private final int id;

    @ApiModelProperty("Наименование")
    private final String name;

    @ApiModelProperty("Индекс для сортировки")
    private final int sort;

    @ApiModelProperty("Признак того что категория скрыта")
    private final boolean isHidden;

    @ApiModelProperty("Шаблон карточки товара данной категории")
    private final String productLayoutTemplate;
}
