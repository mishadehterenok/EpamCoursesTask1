package com.epam.shapes.observer;

public interface PyramidObservable {

    void attach(PyramidObserver observer);

    void detach(PyramidObserver observer);

    void notifyObservers();
}
