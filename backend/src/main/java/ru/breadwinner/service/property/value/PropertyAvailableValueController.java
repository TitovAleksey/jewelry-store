package ru.breadwinner.service.property.value;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Допустимые значения дополнительных свойств")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/property/{propertyId:\\d+}/value")
public class PropertyAvailableValueController {

    private final PropertyAvailableValueService propertyAvailableValueService;

    @ApiOperation("Получить все значения дополнительного свойства")
    @GetMapping
    public List<PropertyAvailableValueDTO> getAllByProperty(@ApiParam("Идентификатор дополнительного свойства")
                                                            @PathVariable int propertyId) {
        return propertyAvailableValueService.getAllByProperty(propertyId);
    }

    @ApiOperation("Получить значение дополнительного свойства по идентификатору")
    @GetMapping("/{valueId:\\d+}")
    public PropertyAvailableValueDTO getPropertyAndId(@ApiParam("Идентификатор дополнительного свойства")
                                                      @PathVariable int propertyId,
                                                      @ApiParam("Идентификатор значения дополнительного свойства")
                                                      @PathVariable int valueId) {
        return propertyAvailableValueService.getByPropertyAndId(propertyId, valueId);
    }

    @ApiOperation("Создать значение дополнительного свойства")
    @PostMapping
    public PropertyAvailableValueDTO add(@ApiParam("Идентификатор дополнительного свойства")
                                         @PathVariable int propertyId,
                                         @Valid PropertyAvailableValueEditDTO request) {
        return propertyAvailableValueService.add(propertyId, request);
    }

    @ApiOperation("Изменить значение дополнительного свойства")
    @PutMapping("/{valueId:\\d+}")
    public PropertyAvailableValueDTO update(@ApiParam("Идентификатор дополнительного свойства")
                                            @PathVariable int propertyId,
                                            @ApiParam("Идентификатор значения дополнительного свойства")
                                            @PathVariable int valueId,
                                            @Valid PropertyAvailableValueEditDTO request) {
        return propertyAvailableValueService.update(propertyId, valueId, request);
    }

    @ApiOperation("Удалить значение дополнительного свойства")
    @DeleteMapping("/{valueId:\\d+}")
    public void delete(@ApiParam("Идентификатор дополнительного свойства")
                       @PathVariable int propertyId,
                       @ApiParam("Идентификатор значения дополнительного свойства")
                       @PathVariable int valueId) {
        propertyAvailableValueService.deleteByPropertyAndId(propertyId, valueId);
    }
}
