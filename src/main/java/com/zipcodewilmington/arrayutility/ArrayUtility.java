package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    ArrayList<T> arrayList;
    T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
        this.arrayList = new ArrayList<>(Arrays.asList(inputArray));
    }

    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        this.arrayList.addAll(Arrays.asList(arrayToMerge));
        return getNumberOfOccurrences(valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T mostCommon = arrayToMerge[0];
        for(T element: arrayToMerge){
            if (getNumberOfOccurrences(element) > getNumberOfOccurrences(mostCommon)){
                mostCommon = element;
            }
        }
        return mostCommon;
    }

    public int getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for(T value: this.arrayList){
            if(value.equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> output = new ArrayList<>();
        for(T value: this.arrayList){
            if(value != valueToRemove){
                output.add(value);
            }
        }
        this.array = Arrays.copyOfRange(this.array, 0, output.size());
        int i = 0;
        for(T value: output){
            this.array[i] = value;
            i++;
        }
        return array;
    }
}
