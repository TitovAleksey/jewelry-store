package ru.breadwinner.service.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.breadwinner.service.product.property.value.ProductPropertyValue;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Api(tags = "Товары")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @ApiOperation("Получить список товаров")
    @GetMapping
    public Page<ProductDTO> getAll() {

    }

    @ApiOperation("Получить товар по идентификатору")
    @GetMapping("/{id:\\d+}")
    public ProductDTO getById(@ApiParam("Идентификатор") @PathVariable int id) {

    }

    @ApiOperation("Добавить товар")
    @PostMapping
    public ProductDTO add(@Valid ProductEditDTO request) {

    }

    @ApiOperation("Изменить товар")
    @PutMapping("/{id:\\d+}")
    public ProductDTO update(@ApiParam("Идентификатор") @PathVariable int id,
                             @Valid ProductEditDTO request) {

    }

    @ApiOperation("Удалить товар")
    @DeleteMapping("/{id:\\d+}")
    public void delete(@ApiParam("Идентификатор") @PathVariable int id) {

    }

    @ApiOperation("Получить дополнительные свойства товара")
    @GetMapping("/{id:\\d+}/property")
    public List<ProductPropertyValue> getProductProperties(@ApiParam("Идентификатор") @PathVariable int id) {

    }
}
