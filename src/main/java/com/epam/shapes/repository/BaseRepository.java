package com.epam.shapes.repository;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.specification.BaseSpecification;

import java.util.Comparator;
import java.util.List;

public interface BaseRepository<T> {
    int size();
    void add(Pyramid pyramid) ;
    void set(int index, Pyramid pyramid);
    T get(int index);
    void remove(Pyramid pyramid);
    void clear();
    boolean isEmpty();
    List<T> getStorage();
    List<T> sort(Comparator<T> comparator);
    List<T> query(BaseSpecification specification);
}
