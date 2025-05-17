package SortingStrategy;

import java.util.Arrays;

public class SortingStrategyDemo {
    public static void main(String[] args) {
        // Create test array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        int[] arr2 = arr1.clone(); // Create a copy for second test

        // Create sorter with bubble sort strategy
        Sorter sorter = new Sorter(new BubbleSortStrategy());
        
        // Sort using bubble sort
        System.out.println("Original array: " + Arrays.toString(arr1));
        sorter.sortArray(arr1);
        System.out.println("After bubble sort: " + Arrays.toString(arr1));

        // Change strategy to selection sort
        sorter.setStrategy(new SelectionSortStrategy());
        
        // Sort using selection sort
        System.out.println("\nOriginal array: " + Arrays.toString(arr2));
        sorter.sortArray(arr2);
        System.out.println("After selection sort: " + Arrays.toString(arr2));
    }
} 