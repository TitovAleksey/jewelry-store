package ru.breadwinner.service.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@ApiModel("Категория (запрос на создание и изменение)")
@Data
public class CategoryEditDTO {

    @ApiModelProperty("Наименование")
    @NotBlank(message = "Наименование не заполнено")
    private String name;

    @ApiModelProperty("Индекс для сортировки")
    @ApiParam(defaultValue = "0")
    private int sort;

    @ApiModelProperty("Признак того что категория скрыта")
    @ApiParam(defaultValue = "false")
    private boolean isHidden;

    @ApiModelProperty("Шаблон карточки товара данной категории")
    @NotBlank(message = "Не заполнен шаблон карточки товара")
    private String productLayoutTemplate;

    @ApiModelProperty("Идентификаторы дополнительных свойств, используемых в данной категории")
    private Set<Integer> propertyIds;
}
