package ru.breadwinner.service.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@ApiModel("Товар")
@Builder
@Getter
public class ProductDTO {

    @ApiModelProperty("Идентификатор")
    private final int id;

    @ApiModelProperty("Наименование")
    private final String name;

    @ApiModelProperty("Признак того что товар скрыт")
    private final boolean isHidden;
}