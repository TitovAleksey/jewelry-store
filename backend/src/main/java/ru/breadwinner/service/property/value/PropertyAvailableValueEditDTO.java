package ru.breadwinner.service.property.value;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("Допустимое значение дополнительного свойства (запрос на создание и изменение)")
@Data
public class PropertyAvailableValueEditDTO {

    @ApiModelProperty("Значение")
    @NotBlank(message = "Не заполнено значение")
    private final String value;
}
