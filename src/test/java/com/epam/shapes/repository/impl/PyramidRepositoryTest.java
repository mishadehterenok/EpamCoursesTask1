package com.epam.shapes.repository.impl;

import com.epam.shapes.comparator.PyramidComparator;
import com.epam.shapes.entity.Pyramid;
import com.epam.shapes.exception.PyramidException;
import com.epam.shapes.factory.PyramidFactory;
import com.epam.shapes.filler.impl.PyramidRepositoryFiller;
import com.epam.shapes.observer.impl.PyramidObserverImpl;
import com.epam.shapes.specification.impl.PyramidAreaSpecification;
import com.epam.shapes.specification.impl.PyramidRangeIdSpecification;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;


public class PyramidRepositoryTest {
    private final PyramidRepository repository = PyramidRepository.getInstance();
    private static Pyramid pyramid1;
    private static Pyramid pyramid2;

    @BeforeEach
    void setUp() throws PyramidException {
        PyramidFactory pyramidFactory = PyramidFactory.getInstance();
        PyramidObserverImpl observer = new PyramidObserverImpl();
        PyramidRepositoryFiller repositoryFiller = new PyramidRepositoryFiller();
        List<Double> coordinates = new ArrayList<>();
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(4.0);
        coordinates.add(5.0);
        coordinates.add(10.0);
        pyramid1 = pyramidFactory.getPyramid(coordinates);
        pyramid1.attach(observer);
        List<Pyramid> pyramids = new ArrayList<>();
        pyramids.add(pyramid1);
        repositoryFiller.fill(pyramids);
        List<Double> coordinates2 = new ArrayList<>();
        coordinates2.add(2.0);
        coordinates2.add(3.0);
        coordinates2.add(4.0);
        coordinates2.add(5.0);
        coordinates2.add(6.0);
        pyramid2 = pyramidFactory.getPyramid(coordinates2);
        pyramid2.attach(observer);
    }

    @AfterEach
    public void tearDown(){
        repository.clear();
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(repository.size(), 1);
    }

    @Test
    public void testAdd() {
        repository.add(pyramid2);
        Assertions.assertEquals(repository.size(), 2);
    }

    @Test
    public void testRemove() {
        repository.remove(pyramid1);
        Assertions.assertEquals(repository.size(), 0);
    }

    @Test
    public void ifSetAndGetMethodsWork() throws PyramidException {
        repository.set(0, pyramid2);
        Assertions.assertEquals(pyramid2, repository.get(0));
    }

    @Test
    public void testClear() {
        repository.clear();
        Assertions.assertEquals(repository.size(), 0);
    }

    @Test
    public void testSortByXCoordinate() {
        PyramidComparator comparator = PyramidComparator.X_COORDINATE;
        repository.add(pyramid2);
        List<Pyramid> actual = repository.sort(comparator);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid2);
        expected.add(pyramid1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testQueryByIdSpecification() {
        repository.add(pyramid2);
        PyramidRangeIdSpecification specification = new PyramidRangeIdSpecification(0, 20);
        List<Pyramid> actual = repository.query(specification);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid1);
        expected.add(pyramid2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testQueryByAreaSpecification() {
        repository.add(pyramid2);
        PyramidAreaSpecification specification = new PyramidAreaSpecification(110.0, 140.0);
        List<Pyramid> actual = repository.query(specification);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetStorage() {
        repository.add(pyramid2);
        List<Pyramid> actual = repository.getStorage();
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid1);
        expected.add(pyramid2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSortById() {
        PyramidComparator comparator = PyramidComparator.ID;
        repository.remove(pyramid1);
        repository.add(pyramid2);
        repository.add(pyramid1);
        List<Pyramid> actual = repository.sort(comparator);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid1);
        expected.add(pyramid2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSortByArea() {
        PyramidComparator comparator = PyramidComparator.AREA;
        repository.add(pyramid2);
        List<Pyramid> actual = repository.sort(comparator);
        List<Pyramid> expected = new ArrayList<>();
        expected.add(pyramid2);
        expected.add(pyramid1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        repository.clear();
        Assertions.assertTrue(repository.isEmpty());
    }
}