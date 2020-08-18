package com.kostin.algorithms;

/**
 * @author Kostin Denis
 */

public interface MapInterface {

    void put(int key, long value);
    long getValue(int key);
    int size();
    boolean isEmpty();

}
