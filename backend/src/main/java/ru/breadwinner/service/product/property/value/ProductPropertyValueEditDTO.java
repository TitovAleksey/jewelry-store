package ru.breadwinner.service.product.property.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@ApiModel("Значение дополнительного свойства (запрос на изменение)")
@Data
public class ProductPropertyValueEditDTO {

    @ApiModelProperty("Идентификатор свойства")
    @Positive(message = "Идентификатор свойства не задан")
    private final int propertyId;

    @ApiModelProperty("Строковое значение")
    private final String textValue;

    @ApiModelProperty("Числовое значение")
    private final BigDecimal numberValue;

    @ApiModelProperty("Идентификатор")
    private final int dictionaryValueId;
}
