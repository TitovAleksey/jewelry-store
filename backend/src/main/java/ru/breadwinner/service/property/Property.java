package ru.breadwinner.service.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.breadwinner.service.category.Category;
import ru.breadwinner.service.property.type.PropertyType;
import ru.breadwinner.service.property.value.PropertyAvailableValue;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "property")
public class Property {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "property_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private PropertyType type;

    @Column(name = "is_hidden")
    private boolean isHidden;

    @Column(name = "is_use_in_filter")
    private boolean isUseInFilter;

    @ManyToMany
    @JoinTable(name = "category_property",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @OneToMany(mappedBy = "property")
    private Set<PropertyAvailableValue> availableValues;
}
