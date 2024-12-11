/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: QuickSort_EthanB.java
Description:
Uses a quick sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.Random;

public class QuickSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       quickSort(arr, 0, (arr.length - 1)); //Commence quick sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high); //Divide the search space
 
            quickSort(arr, low, pi - 1); //Sort elements before and after partition
            quickSort(arr, pi + 1, high);
        }//end if
    }//end quickSort
    
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high]; //Value at highest position is pivot value
 
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++)
        {
            if (arr[j] < pivot) //If the current element is smaller than the pivot
            {
                i++;
                swap(arr, i, j);
            }//end if
        }//end for
        swap(arr, i + 1, high);
        return (i + 1);
    }//end partition
    
    static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a]; //Swap two values
        arr[a] = arr[b];
        arr[b] = temp;
    }//end swap

    public static int[] generateRandomArray(int size)
    {
        Random random = new Random(555);
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = random.nextInt(size); //Generate random numbers from 0 to [arraySize - 1]
        }//end for
        return arr;
    }//end generateRandomArray
    
    public static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " "); //Print the first n elements of a specified array
        }//end for
        System.out.println(" ..."); //Indicates there are more elements not shown (for output simplicity)
    }//end printArray
}//end QuickSort_EthanB