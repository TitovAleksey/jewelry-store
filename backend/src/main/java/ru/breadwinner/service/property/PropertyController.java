package ru.breadwinner.service.property;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.breadwinner.service.property.type.PropertyTypeDTO;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Api(tags = "Дополнительные свойства")
@RestController
@RequestMapping("/api/property")
public class PropertyController {

    private final PropertyService propertyService;

    @ApiOperation("Получить все типы дополнительных свойств")
    @GetMapping("/type")
    public List<PropertyTypeDTO> getAllTypes() {
        return propertyService.getTypes();
    }

    @ApiOperation("Получить все дополнительные свойства")
    @GetMapping
    public List<PropertyDTO> getAll() {
        return propertyService.getAll();
    }

    @ApiOperation("Получить дополнительное свойство по идентификатору")
    @GetMapping("/{id:\\d+}")
    public PropertyDTO getById(@ApiParam("Идентификатор") @PathVariable int id) {
        return propertyService.getById(id);
    }

    @ApiOperation("Добавить дополнительное свойство")
    @PostMapping
    public PropertyDTO add(@Valid PropertyEditDTO request) {
        return propertyService.add(request);
    }

    @ApiOperation("Изменить дополнительное свойство")
    @PutMapping("/{id:\\d+}")
    public PropertyDTO update(@ApiParam("Идентификатор") @PathVariable int id, @Valid PropertyEditDTO request) {
        return propertyService.update(id, request);
    }

    @ApiOperation("Удалить дополнительное свойство")
    @DeleteMapping("/{id:\\d+}")
    public void delete(@ApiParam("Идентификатор") @PathVariable int id) {
        propertyService.delete(id);
    }
}
