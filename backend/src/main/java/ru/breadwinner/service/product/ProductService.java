package ru.breadwinner.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.breadwinner.service.category.CategoryDAO;
import ru.breadwinner.service.product.property.value.ProductPropertyValue;
import ru.breadwinner.service.product.property.value.ProductPropertyValueDAO;
import ru.breadwinner.service.product.property.value.ProductPropertyValueDTO;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDAO productDAO;
    private final CategoryDAO categoryDAO;
    private final ProductPropertyValueDAO productPropertyValueDAO;
    private final ConversionService conversionService;

    public Page<ProductDTO> getAll(int pageNumber, int pageSize) {
        return productDAO.getAll(pageNumber, pageSize)
                .map(this::convertProduct);
    }

    private ProductDTO convertProduct(Product product) {
        return conversionService.convert(product, ProductDTO.class);
    }

    public ProductDTO getById(int id) {
        Product product = productDAO.getById(id);
        return convertProduct(product);
    }

    public ProductDTO add(ProductEditDTO request) {
        Product product = new Product();
        fillProduct(product, request);
        product = productDAO.save(product);
        return convertProduct(product);
    }

    private void fillProduct(Product product, ProductEditDTO source) {
        //TODO: заполнение дополнительных свойств
        product.setName(source.getName())
                .setPrice(source.getPrice())
                .setHidden(source.isHidden())
                .setCategory(categoryDAO.getById(source.getCategoryId()))
        ;
    }

    public ProductDTO update(int id, ProductEditDTO request) {
        Product product = productDAO.getById(id);
        fillProduct(product, request);
        product = productDAO.save(product);
        return convertProduct(product);
    }

    public void delete(int id) {
        //TODO: удалить свойства
        Product product = productDAO.getById(id);
        productDAO.delete(product);
    }

    public List<ProductPropertyValueDTO> getAllByProduct(int productId) {
        Product product = productDAO.getById(productId);
        return productPropertyValueDAO.getAllByProduct(product).stream()
                .map(this::convertProductPropertyValue)
                .collect(Collectors.toList());
    }

    private ProductPropertyValueDTO convertProductPropertyValue(ProductPropertyValue source) {
        return conversionService.convert(source, ProductPropertyValueDTO.class);
    }
}
