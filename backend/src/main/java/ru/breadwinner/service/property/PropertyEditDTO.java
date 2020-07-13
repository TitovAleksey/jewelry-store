package ru.breadwinner.service.property;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import ru.breadwinner.service.property.type.PropertyType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("Дополнительное свойство (запрос на создание и изменение)")
@Data
public class PropertyEditDTO {

    @ApiModelProperty(value = "Наименование", required = true)
    @NotBlank(message = "Не заполнено наименование")
    private String name;

    @ApiModelProperty(value = "Тип", required = true)
    @NotNull(message = "Не заполнен тип")
    private PropertyType type;

    @ApiModelProperty("Признак того что свойство скрыто")
    @ApiParam(defaultValue = "false")
    private boolean isHidden;

    @ApiModelProperty("Признак того что свойство используется в фильтрах")
    @ApiParam(defaultValue = "false")
    private boolean isUseInFilter;
}
