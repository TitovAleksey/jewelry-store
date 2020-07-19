package ru.breadwinner.service.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import ru.breadwinner.service.product.property.value.ProductPropertyValueEditDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("Товар (запрос на создание и изменение)")
@Data
public class ProductEditDTO {

    @ApiModelProperty("Наименование")
    @NotBlank(message = "Наименование не заполнено")
    private String name;

    @ApiModelProperty("Цена")
    private BigDecimal price;

    @ApiModelProperty("Признак того что товар скрыт")
    @ApiParam(defaultValue = "false")
    private boolean isHidden;

    @ApiModelProperty("Идентификатор категории")
    @Positive(message = "Не указан идентификатор категории")
    private int categoryId;

    @ApiModelProperty("Значения дополнительных свойств")
    private List<ProductPropertyValueEditDTO> propertyValues;
}
