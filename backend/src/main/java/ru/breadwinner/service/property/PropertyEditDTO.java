package ru.breadwinner.service.property;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "Признак того что свойство скрыто", required = true)
    @NotNull(message = "Не заполнен признак скрытия свойства")
    private Boolean isHidden;

    @ApiModelProperty(value = "Признак того что свойство используется в фильтрах", required = true)
    @NotNull(message = "Не заполнен признак использования свойства в фильтрах")
    private Boolean isUseInFilter;
}
