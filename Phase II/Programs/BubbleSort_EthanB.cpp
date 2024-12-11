#include <chrono>
#include <stdlib.h>
#include <iostream>
using namespace std;

//Ethan Boisvert
//CS699 Professional Seminar
//March 16, 2024
//File Name: BubbleSort_EthanB.cpp
//Program Description: Uses a bubble sort algorithm to sort through a set of 100000 elements.

int arr[100000]; //Adjust the size as needed

void bubbleSort(int n)
{
    int i, j;
    bool swapped;

    for (i = 0; i < n - 1; i++)
    {
        swapped = false;
        for (j = 0; j < n - i - 1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                swap(arr[j], arr[j + 1]);
                swapped = true;
            }//end if
        }//end for

        if (swapped == false) //Break loop if elements were not swapped
            break;
    }//end for
}//end bubbleSort

void generateRandomArray(int n)
{
    srand(555);
    for (int i = 0; i < n; i++)
    {
        arr[i] = rand(); //Generate random numbers from 0 to [arraySize - 1]
    }//end for
}//end generateRandomArray

void printArray(int n)
{
    int i;
    for (i = 0; i < n; i++)
    {
        cout << arr[i] << " "; //Print the first n elements of a specified array
    }//end for
    cout << " ...\n"; //Indicates there are more elements not shown (for output simplicity)
}//end printArray

int main()
{
    int arraySize = 100000;
    generateRandomArray(arraySize);

    cout << "Set size: " << arraySize << " elements\n";
    cout << "Original Array (First 10 elements):\n";

    printArray(10); //Print the first 10 elements of the original array

    chrono::time_point<chrono::system_clock> startTime = chrono::system_clock::now(); //Start counting milliseconds

    bubbleSort(arraySize); //Commence bubble sort

    chrono::time_point<chrono::system_clock> endTime = chrono::system_clock::now(); //Stop counting milliseconds
    long elapsedTime = chrono::duration_cast<chrono::nanoseconds>(endTime - startTime).count(); //Determine total number of milliseconds taken to sort

    cout << "\nSorted Array (First 10 elements):\n";
    printArray(10); //Print the first 10 elements of the sorted array

    cout << "\nTime taken for sorting: " << (elapsedTime / 1e6) << " milliseconds"; //Display time taken to sort (in milliseconds)
    return 0;
}//end main
