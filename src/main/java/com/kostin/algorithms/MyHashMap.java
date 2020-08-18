package com.kostin.algorithms;

import java.util.Arrays;

/**
 * @author Kostin Denis
 */

public class MyHashMap implements MapInterface{

    public MyHashMap() {
        keys = new int[maxLenght];
        values = new long[maxLenght];
    }

    @Override
    public void printMaxLenght(){
        System.out.println(maxLenght);
    }

    public void printAllArray(){
        for(int i=0; i<maxLenght; i++)
            System.out.print("["+keys[i]+" = "+values[i]+"] ");
    }

    private short doubleDegrees = 4;
    private int maxLenght = 16;
    private int lenght = 0;
    private int[] keys;
    private long[] values;

    private void improveArrays(int[] keysNow, long[] valuesNow) {
        maxLenght = (int) Math.pow(2, ++doubleDegrees);
        keys = Arrays.copyOf(keysNow, maxLenght);
        values = Arrays.copyOf(valuesNow, maxLenght);
    }

    private boolean isFull() {
        return lenght==maxLenght;
    }

    @Override
    public boolean isEmpty() {
        return lenght==0;
    }

    @Override
    public void put(int key, long value) {
        if(isFull()) {
            improveArrays(keys,values);
        }
        keys[lenght] = key;
        values[lenght] = value;
        lenght++;
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
                int temp = arr[leftMarker];
                arr[leftMarker] = arr[rightMarker];
                arr[rightMarker] = temp;

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
    public long get(int key) {
        if (isEmpty()){
            throw new NegativeArraySizeException("HashMap is Empty!!!");
        }
        //quickSort(keys,0, keys.length-1);
        quickSort(keys, 0 , lenght-1);
        //Arrays.stream(keys).forEach(a-> System.out.print(a+" "));
        return 0;
    }

    @Override
    public int size() {
        return lenght;
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
        for (int i=0; i<lenght; i++) {
            str+=("["+keys[i]+" = "+values[i]+"] ");
        }
        return str;
    }
}