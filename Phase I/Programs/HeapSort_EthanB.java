/**
Name: Ethan Boisvert
CS699C Professional Seminar
File Name: HeapSort_EthanB.java
Description:
Uses a heap sort algorithm to sort through an array of elements. The size of this array can be adjusted when necessary.
The program times itself to determine how many milliseconds were taken to sort through all elements in the array from least to greatest.
**/

import java.util.Random;

public class HeapSort_EthanB
{
    public static void main(String[] args)
    {
       int arraySize = 1000000; //Adjust the size as needed
       int[] arr = generateRandomArray(arraySize);
       
       System.out.println("\nSet size: " + (arraySize) + " elements");
       System.out.println("Original Array (First 10 elements):");
       
       printArray(arr, 10); //Print the first 10 elements of the original array
       long startTime = System.nanoTime(); //Start counting milliseconds
       
       heapSort(arr); //Commence heap sort
       
       long endTime = System.nanoTime(); //Stop counting milliseconds
       long elapsedTime = endTime - startTime; //Determine total number of milliseconds taken to sort
       
       System.out.println("\nSorted Array (First 10 elements):");
       printArray(arr, 10); //Print the first 10 elements of the sorted array
       
       System.out.println("\nTime taken for sorting: " + (elapsedTime / 1e6) + " milliseconds"); //Display time taken to sort (in milliseconds)
    }//end main

    public static void heapSort(int arr[])
    {
        int n = arr.length;

        //Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i); //Heapify the subtree rooted at index i
        }//end for

        //Extract elements from the max heap one by one
        for (int i = n - 1; i >= 1; i--)
        {
            swap(arr, 0, i); //Swap the root (maximum element) with the last element

            n--; //Reduce the heap size

            //Heapify the root element to maintain the max heap property
            heapify(arr, n, 0);
        }//end for
    }//end heapSort

    private static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[leftChild] > arr[largest])
        {
            largest = leftChild;
        }//end if

        if (rightChild < n && arr[rightChild] > arr[largest])
        {
            largest = rightChild;
        }//end if

        if (largest != i)
        {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }//end if
    }//end heapify

    private static void swap(int arr[], int a, int b)
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
}//end HeapSort_EthanB