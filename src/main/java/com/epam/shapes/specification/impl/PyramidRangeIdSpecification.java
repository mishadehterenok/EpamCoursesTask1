package com.epam.shapes.specification.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.specification.BaseSpecification;

public class PyramidRangeIdSpecification implements BaseSpecification<Pyramid> {

    private final int idFrom;
    private final int idTo;

    public PyramidRangeIdSpecification(int idFrom, int idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    @Override
    public boolean specify(Pyramid pyramid) {
        return ((pyramid.getId() >= idFrom) && (pyramid.getId() < idTo));
    }
}
