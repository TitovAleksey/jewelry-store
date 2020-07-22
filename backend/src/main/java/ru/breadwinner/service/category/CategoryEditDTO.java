package ru.breadwinner.service.category;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@ApiModel("Категория (запрос на создание и изменение)")
@Data
public class CategoryEditDTO {

    @ApiModelProperty("Наименование")
    @NotBlank(message = "Наименование не заполнено")
    private String name;

    @ApiModelProperty("Индекс для сортировки")
    @NotNull(message = "Не заполнен индекс для сортировки")
    private Integer sort;

    @ApiModelProperty("Признак того что категория скрыта")
    @NotNull(message = "Не заполнен признак скрытия категории")
    private Boolean isHidden;

    @ApiModelProperty("Шаблон карточки товара данной категории")
    @NotBlank(message = "Не заполнен шаблон карточки товара")
    private String productLayoutTemplate;

    @ApiModelProperty("Идентификаторы дополнительных свойств, используемых в данной категории")
    private Set<Integer> propertyIds;
}
