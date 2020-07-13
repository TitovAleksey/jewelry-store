package ru.breadwinner.service.category;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import ru.breadwinner.service.property.Property;

import javax.persistence.*;
import java.util.Set;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "category")
public class Category {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "category_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private int sort;

    @Column(name = "is_hidden")
    private boolean isHidden;

    @Column(name = "product_layout_template")
    private String productLayoutTemplate;

    @ManyToMany
    @JoinTable(name = "category_property",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "property_id"))
    private Set<Property> properties;
}
