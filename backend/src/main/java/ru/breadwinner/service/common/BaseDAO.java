package ru.breadwinner.service.common;

import java.util.List;

public interface BaseDAO<T> {

    List<T> getAll();

    T getById(int id);

    T save(T entity);

    void delete(T entity);
}
