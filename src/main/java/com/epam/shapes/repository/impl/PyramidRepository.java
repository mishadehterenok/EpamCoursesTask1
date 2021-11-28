package com.epam.shapes.repository.impl;

import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.repository.BaseRepository;
import com.epam.shapes.specification.BaseSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PyramidRepository implements BaseRepository<Pyramid> {
    private static final PyramidRepository instance = new PyramidRepository();
    private final List<Pyramid> pyramidStorage;

    private PyramidRepository() {
        pyramidStorage = new ArrayList<>();
    }

    public static PyramidRepository getInstance() {
        return instance;
    }

    @Override
    public int size() {
        return pyramidStorage.size();
    }

    @Override
    public void add(Pyramid pyramid) {
        pyramidStorage.add(pyramid);
    }

    @Override
    public void set(int index, Pyramid pyramid) {
        pyramidStorage.set(index, pyramid);
    }

    @Override
    public Pyramid get(int index) {
        return pyramidStorage.get(index);
    }

    @Override
    public void remove(Pyramid pyramid) {
        pyramidStorage.remove(pyramid);
    }

    @Override
    public void clear() {
        pyramidStorage.clear();
    }

    @Override
    public boolean isEmpty() {
        return pyramidStorage.isEmpty();
    }

    @Override
    public List<Pyramid> getStorage() {
        return List.copyOf(pyramidStorage);
    }

    @Override
    public List<Pyramid> sort(Comparator<Pyramid> comparator) {
        return pyramidStorage.stream()
                .sorted(comparator)
                .toList();
    }

    @Override
    public List<Pyramid> query(BaseSpecification specification) {
        return pyramidStorage.stream()
                .filter(specification::specify)
                .toList();
    }
}
