package com.kostin.algorithms;

import lombok.SneakyThrows;

import java.util.Arrays;

/**
 * @author Kostin Denis
 */

public class MyHashMap implements MapInterface{

    public MyHashMap() {
        keys = new int[maxLenght];
        values = new long[maxLenght];
    }

    private boolean isSorted = false;
    private short doubleDegrees = 4;
    private int maxLenght = 16;
    private int length = 0;
    private int[] keys;
    private long[] values;

    private void improveArrays(int[] keysNow, long[] valuesNow) {
        maxLenght = (int) Math.pow(2, ++doubleDegrees);
        keys = Arrays.copyOf(keysNow, maxLenght);
        values = Arrays.copyOf(valuesNow, maxLenght);
    }

    private boolean isFull() {
        return length == maxLenght;
    }

    @Override
    public boolean isEmpty() {
        return length ==0;
    }

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
        String str = "";
        for (int i = 0; i< length; i++) {
            str+=("["+keys[i]+" = "+values[i]+"] ");
        }
        return str;
    }
}