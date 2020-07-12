package ru.breadwinner.service.property.value;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.breadwinner.service.property.Property;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "property_available_value")
public class PropertyAvailableValue {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "property_available_value_id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private Property property;

    @Column(name = "value")
    private String value;
}
