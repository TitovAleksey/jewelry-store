package ru.breadwinner.service.category;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.breadwinner.service.property.PropertyDTO;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Категории товара")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation("Получить все категории")
    @GetMapping
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }

    @ApiOperation("Получить категорию по идентификатору")
    @GetMapping("/{id}")
    public CategoryDTO getById(@ApiParam("Идентификатор категории") @PathVariable int id) {
        return categoryService.getById(id);
    }

    @ApiOperation("Создать категорию")
    @PostMapping
    public CategoryDTO add(@RequestBody @Valid CategoryEditDTO request) {
        return categoryService.add(request);
    }

    @ApiOperation("Изменить категорию")
    @PutMapping("/{id}")
    public CategoryDTO update(@ApiParam("Идентификатор категории") @PathVariable int id,
                              @RequestBody @Valid CategoryEditDTO request) {
        return categoryService.update(id, request);
    }

    @ApiOperation("Удалить категорию")
    @DeleteMapping("/{id}")
    public void delete(@ApiParam("Идентификатор категории") @PathVariable int id) {
        categoryService.delete(id);
    }

    @ApiOperation("Получить список дополнительных свойств категории")
    @GetMapping("/{id}/property")
    public List<PropertyDTO> getProperties(@ApiParam("Идентификатор категории") @PathVariable int id) {
        return categoryService.getPropertiesByCategory(id);
    }
}
