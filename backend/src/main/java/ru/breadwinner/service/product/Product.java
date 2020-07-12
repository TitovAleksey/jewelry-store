package ru.breadwinner.service.product;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.breadwinner.service.category.Category;
import ru.breadwinner.service.product.property.value.ProductPropertyValue;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_hidden")
    private boolean isHidden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ProductPropertyValue> propertyValues;
}
