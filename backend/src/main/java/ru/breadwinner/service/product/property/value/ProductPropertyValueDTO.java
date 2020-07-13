package ru.breadwinner.service.product.property.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@ApiModel("Значение дополнительного свойства")
@Builder
@Getter
public class ProductPropertyValueDTO {

    @ApiModelProperty("Идентификатор свойства")
    private final int propertyId;

    @ApiModelProperty("Строковое значение")
    private final String textValue;

    @ApiModelProperty("Числовое значение")
    private final BigDecimal numberValue;

    @ApiModelProperty("Идентификатор")
    private final int dictionaryValueId;
}
