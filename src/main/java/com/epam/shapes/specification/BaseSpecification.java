package com.epam.shapes.specification;

import com.epam.shapes.entity.Pyramid;

public interface BaseSpecification<T> {
    boolean specify(T t);
}
