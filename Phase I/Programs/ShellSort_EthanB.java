/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: ShellSort_EthanB.java
Description:
Uses a shell sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.Random;

public class ShellSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       shellSort(arr); //Commence shell sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void shellSort(int arr[])
    {
        int n = arr.length;
        
        for (int gap = n / 2; gap > 0; gap /= 2) //Start with large gap, then reduce it
        { 
            //For this gap size, use gapped insertion sort
            for (int i = gap; i < n; i += 1) 
            { 
                int temp = arr[i]; //Add a[i] to elements that have been gap sorted except for a[i], make a hole at position i
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                {
                    arr[j] = arr[j - gap]; //Shift earlier gap sorted elements up until a[i]'s location is determined
                }//end for
                
                arr[j] = temp; //Put temp in its correct location
            } //end for
        }//end for
    }//end shellSort

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
}//end ShellSort_EthanB