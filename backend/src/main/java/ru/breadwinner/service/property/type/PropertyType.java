package ru.breadwinner.service.property.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PropertyType {

    NUMBER("Число"),
    STRING("Строка"),
    DICTIONARY("Справочник");

    private final String description;
}
