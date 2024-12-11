/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: BucketSort_EthanB.java
Description:
Uses a bucket sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.*;

public class BucketSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       float[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       bucketSort(arr); //Commence bucket sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void bucketSort(float arr[])
    {
        int n = arr.length;
        
        if (n <= 0) //If array is empty
        {
            return;
        }//end if
        
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n]; //Create n empty buckets
 
        for (int i = 0; i < n; i++)
        {
            buckets[i] = new Vector<Float>();
        }//end for
        
        for (int i = 0; i < n; i++)
        {
            float idx = arr[i] * n; //Put elements into buckets
            buckets[(int)idx].add(arr[i]);
        }//end for
        
        for (int i = 0; i < n; i++)
        {
            Collections.sort(buckets[i]); //Sort the buckets
        }//end for
        
        int index = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < buckets[i].size(); j++)
            {
                arr[index++] = buckets[i].get(j); //Concatenate buckets into array
            }//end for
        }//end for
    }//end bucketSort

    public static float[] generateRandomArray(int size)
    {
        Random random = new Random(555);
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = random.nextFloat(); //Generate random numbers between 0 and 1
        }//end for
        return arr;
    }//end generateRandomArray
    
    public static void printArray(float arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " "); //Print the first n elements of a specified array
        }//end for
        System.out.println(" ..."); //Indicates there are more elements not shown (for output simplicity)
    }//end printArray
}//end BucketSort_EthanB