/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: RadixSort_EthanB.java
Description:
Uses a radix sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.*;

public class RadixSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       radixSort(arr); //Commence radix sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void radixSort(int arr[])
    {
        int n = arr.length;
        
        int max = getMax(arr, n);
        
        for (int exp = 1; max / exp > 0; exp *= 10)
        {
            countSort(arr, n, exp); //Perform count sort for each digit
        }//end for
    }//end radixSort
    
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        
        for (i = 0; i < n; i++)
        {
            count[(arr[i] / exp) % 10]++; //Store occurrences of count
        }//end for
        
        for (i = 1; i < 10; i++)
        {
            count[i] += count[i - 1]; //Change count[i] to current digit
        }//end for
        
        for (i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; //Build output array
            count[(arr[i] / exp) % 10]--;
        }//end for
        
        for (i = 0; i < n; i++)
        {
            arr[i] = output[i]; //Copy output array to arr
        }//end for
    }//end countSort
    
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > mx)
            {
                mx = arr[i];
            }//end if
        }//end for
        return mx;
    }//end getMax

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
}//end RadixSort_EthanB