package ru.breadwinner.service.product;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.breadwinner.service.category.Category;
import ru.breadwinner.service.product.property.value.ProductPropertyValue;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
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

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;
}
