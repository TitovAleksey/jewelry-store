package ru.breadwinner.service.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.breadwinner.service.product.property.value.ProductPropertyValueDTO;

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
    public Page<ProductDTO> getAll(@ApiParam(value = "Номер страницы", required = true) @RequestParam("pageNumber") int pageNumber,
                                   @ApiParam(value = "Номер страницы", required = true) @RequestParam("pageSize") int pageSize) {
        return productService.getAll(pageNumber, pageSize);
    }

    @ApiOperation("Получить товар по идентификатору")
    @GetMapping("/{id:\\d+}")
    public ProductDTO getById(@ApiParam("Идентификатор") @PathVariable int id) {
        return productService.getById(id);
    }

    @ApiOperation("Добавить товар")
    @PostMapping
    public ProductDTO add(@RequestBody @Valid ProductEditDTO request) {
        return productService.add(request);
    }

    @ApiOperation("Изменить товар")
    @PutMapping("/{id:\\d+}")
    public ProductDTO update(@ApiParam("Идентификатор") @PathVariable int id,
                             @RequestBody @Valid ProductEditDTO request) {
        return productService.update(id, request);
    }

    @ApiOperation("Удалить товар")
    @DeleteMapping("/{id:\\d+}")
    public void delete(@ApiParam("Идентификатор") @PathVariable int id) {
        productService.delete(id);
    }

    @ApiOperation("Получить дополнительные свойства товара")
    @GetMapping("/{id:\\d+}/property")
    public List<ProductPropertyValueDTO> getProductProperties(@ApiParam("Идентификатор") @PathVariable int id) {
        return productService.getAllByProduct(id);
    }
}
