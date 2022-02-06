package com.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T current();
    void next();
}
