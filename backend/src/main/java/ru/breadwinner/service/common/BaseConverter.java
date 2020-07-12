package ru.breadwinner.service.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public abstract class BaseConverter<S, D> implements Converter<S, D> {

    @Override
    public D convert(@Nullable S source) {
        return source == null ? null : convertInternal(source);
    }

    protected abstract D convertInternal(S source);
}
