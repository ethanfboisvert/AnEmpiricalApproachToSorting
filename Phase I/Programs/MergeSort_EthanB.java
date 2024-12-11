/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: MergeSort_EthanB.java
Description:
Uses a merge sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.Random;

public class MergeSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       mergeSort(arr, 0, (arr.length - 1)); //Commence merge sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main
    
    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            //Find the middle point
            int m = l + (r - l) / 2;
 
            //Sort the halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            //Merge the halves
            merge(arr, l, m, r);
        }//end if
    }//end mergeSort

    public static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1; //Find sizes of subarrays to be merged
        int n2 = r - m;
 
        int L[] = new int[n1]; //Create temporary arrays and copy data
        int R[] = new int[n2];
 
        for (int i = 0; i < n1; i++)
        {
            L[i] = arr[l + i];
        }//end for
        for (int j = 0; j < n2; j++)
        {
            R[j] = arr[m + 1 + j];
        }//end for
 
        //Merge the temporary arrays
        
        int i = 0, j = 0;
        
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }//end if
            else
            {
                arr[k] = R[j];
                j++;
            }//end else
            k++;
        }//end while
        
        while (i < n1) //Copy remaining elements of L[]
        {
            arr[k] = L[i];
            i++;
            k++;
        }//end while
        
        while (j < n2) //Copy remaining elements of R[]
        {
            arr[k] = R[j];
            j++;
            k++;
        }//end while
    }//end merge
    
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
}//end MergeSort_EthanB