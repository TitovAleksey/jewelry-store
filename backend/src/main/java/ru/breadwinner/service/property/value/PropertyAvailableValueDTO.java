package ru.breadwinner.service.property.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Допустимое значение дополнительного свойства")
@Getter
@Builder
public class PropertyAvailableValueDTO {

    @ApiModelProperty("Идентификатор")
    private final int id;

    @ApiModelProperty("Значение")
    private final String value;
}
