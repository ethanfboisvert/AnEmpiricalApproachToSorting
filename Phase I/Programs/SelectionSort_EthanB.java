/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: SelectionSort_EthanB.java
Description:
Uses a selection sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.Random;

public class SelectionSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       selectionSort(arr); //Commence selection sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void selectionSort(int arr[])
    {
        int n = arr.length; 
        
        for (int i = 0; i < n - 1; i++) //Move boundary of unsorted subarray
        { 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) //Find the smallest element
            {
                if (arr[j] < arr[min_idx])
                {
                    min_idx = j; //Set index to smallest element
                }//end if
            }//end for
            
            int temp = arr[min_idx]; //Swap the first element with the smallest one
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        }//end for
    }//end selectionSort

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
}//end SelectionSort_EthanB