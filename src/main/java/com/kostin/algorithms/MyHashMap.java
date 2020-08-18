package com.kostin.algorithms;

import lombok.SneakyThrows;

import java.util.Arrays;

/**
 * This class {@link MyHashMap} is equalize to {@link java.util.HashMap}
 * @author Kostin Denis
 */
public class MyHashMap implements MapInterface{

    /**
     * The constructor configures two arrays.
     * 1) for Keys
     * 2) for Values
     *
     * The arrays are enlarged by a power of two.
     * Start length is 16
     */
    public MyHashMap() {
        keys = new int[maxLength];
        values = new long[maxLength];
    }

    private boolean isSorted = false;
    private short doubleDegrees = 4;
    private int maxLength = 16;
    private int length = 0;
    private int[] keys;
    private long[] values;

    /**
     * This void was created for increase a arrays.
     * The arrays are enlarged by a power of two.
     * int[] @param keysNow
     * long[] @param valuesNow
     */
    private void improveArrays(int[] keysNow, long[] valuesNow) {
        maxLength = (int) Math.pow(2, ++doubleDegrees);
        keys = Arrays.copyOf(keysNow, maxLength);
        values = Arrays.copyOf(valuesNow, maxLength);
    }


    /**
     * if HashMap are Empty return false
     * else true
     * boolean @return
     */
    private boolean isFull() {
        return length == maxLength;
    }

    /**
     * if HashMap are Empty return true
     * else false
     * boolean @return
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * This maethod adds values and keys to the HashMap cash
     * int @param key
     * long @param value
     */
    @Override
    public void put(int key, long value) {
        isSorted = false;

        int indexOfKey = binarySearch(key);

        if(indexOfKey!=-1) {
            values[indexOfKey] = value;
        }
        else {
            if(isFull())
                improveArrays(keys,values);
            keys[length] = key;
            values[length] = value;
            length++;
        }
        SortedOrNot();
        isSorted = true;
    }

    /**
     * int @param arr
     * int @param startIndex
     * int @param endIndex
     * int[] @return
     */
    private int[] quickSort(int[] arr, int startIndex, int endIndex) {

        if(startIndex >= endIndex)
            return arr;

        int leftMarker = startIndex;
        int rightMarker = endIndex;

        int middleMarker = leftMarker -(leftMarker - rightMarker)/2;

        while (leftMarker < rightMarker) {
            while((leftMarker < middleMarker) && (arr[leftMarker] <= arr[middleMarker])) leftMarker++;
            while((rightMarker > middleMarker) && (arr[rightMarker] >= arr[middleMarker])) rightMarker--;

            if(leftMarker < rightMarker) {

                // Move Keys
                int temp = arr[leftMarker];
                arr[leftMarker] = arr[rightMarker];
                arr[rightMarker] = temp;

                // Move Values
                long tempValue = values[leftMarker];
                values[leftMarker] = values[rightMarker];
                values[rightMarker] = tempValue;

                // Reverse Markers
                if (leftMarker == middleMarker)
                    middleMarker = rightMarker;
                else if (rightMarker == middleMarker)
                    middleMarker = leftMarker;
            }
        }
        quickSort(arr, startIndex, middleMarker);
        quickSort(arr, middleMarker+1, endIndex);

        return arr;
    }

    /**
     * If HashMap is Empty then will return [ NegativeArraySizeException("This HashMap is Empty!!!") ]
     * If HashMap hasn`t your key then will return [ NullPointerException("This HashMap don`t have this key" + "["+key+"] !!!") ]
     * int @param key
     * long @return
     */
    @Override
    @SneakyThrows
    public long getValue(int key) {
        if (isEmpty())
            throw new NegativeArraySizeException("This HashMap is Empty!!!");

        if(length ==1) {
            if(keys[0]==key)
                return values[0];
            else
                throw new NullPointerException("This HashMap don`t have this key" + "["+key+"] !!!");
        }

        int indexOfValueByKey = binarySearch(key);

        if(indexOfValueByKey==-1)
            throw new NullPointerException("This HashMap don`t have this key" + "["+key+"] !!!");

        return values[indexOfValueByKey];
    }

    private void SortedOrNot() {
        if (!isSorted) {
            quickSort(keys, 0, length - 1);
            isSorted = true;
        }
    }

    private int binarySearch(int searchValue){

        int Start = 0;
        int Finish = length -1;
        int location;

        for(int i = Start; i< length; i++){
            location=(Start+Finish)/2;

            if(keys[location]==searchValue)
                return location;
            else if(keys[location]<searchValue)
                Start=location;
            else if(keys[location]>searchValue)
                Finish=location;
            else
                return -1;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i< length; i++) {
            str.append("[").append(keys[i]).append(" = ").append(values[i]).append("] ");
        }
        return str.toString();
    }
}