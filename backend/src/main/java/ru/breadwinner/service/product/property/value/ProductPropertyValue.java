package ru.breadwinner.service.product.property.value;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.breadwinner.service.product.Product;
import ru.breadwinner.service.property.Property;
import ru.breadwinner.service.property.value.PropertyAvailableValue;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product_property_value")
public class ProductPropertyValue {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "product_property_value_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "text_value")
    private String textValue;

    @Column(name = "number_value")
    private BigDecimal numberValue;

    @ManyToOne
    @Column(name = "property_available_value_id")
    private PropertyAvailableValue dictionaryValue;
}
