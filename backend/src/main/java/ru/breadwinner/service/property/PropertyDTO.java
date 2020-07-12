package ru.breadwinner.service.property;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Дополнительное свойство")
@Builder
@Getter
public class PropertyDTO {

    @ApiModelProperty("Идентификатор")
    private final int id;

    @ApiModelProperty("Наименование")
    private final String name;

    @ApiModelProperty("Тип")
    private final PropertyType type;

    @ApiModelProperty("Признак того что свойство скрыто")
    private final boolean isHidden;

    @ApiModelProperty("Признак того что свойство используется в фильтрах")
    private final boolean isUseInFilter;
}
