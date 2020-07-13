package ru.breadwinner.service.property.type;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@ApiModel("Тип дополнительного свойства")
@Getter
public class PropertyTypeDTO {

    @ApiModelProperty("Код")
    private final PropertyType code;

    @ApiModelProperty("Описание")
    private final String description;

    public PropertyTypeDTO(PropertyType propertyType) {
        code = propertyType;
        description = propertyType.getDescription();
    }
}
