#include <chrono>
#include <stdlib.h>
#include <iostream>
using namespace std;

//Ethan Boisvert
//CS699 Professional Seminar
//March 16, 2024
//File Name: CountingSort_EthanB.cpp
//Program Description: Uses a counting sort algorithm to sort through a set of 100000 elements.

int arr[100000]; //Adjust the size as needed

void countingSort(int n)
{
    int out[n];
    int c[n];
    int mx = arr[0];

    //Find largest element in the array
    for (int i = 1; i < n; i++)
    {
        if (arr[i] > mx)
        mx = arr[i];
    }//end for

    //Initialize count array
    for (int i = 0; i <= mx; ++i)
    {
        c[i] = 0;
    }//end for

    // Store count of each element
    for (int i = 0; i < n; i++)
    {
        c[arr[i]]++;
    }//end for

    //Store cumulative count of each array
    for (int i = 1; i <= mx; i++)
    {
        c[i] += c[i - 1];
    }//end for

    //Find index of each element in count array, place elements in output array
    for (int i = n - 1; i >= 0; i--)
    {
        out[c[arr[i]] - 1] = arr[i];
        c[arr[i]]--;
    }//end for

    //Copy sorted elements into input array
    for (int i = 0; i < n; i++)
    {
        arr[i] = out[i];
    }//end for
}//end countingSort

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

    countingSort(arraySize); //Commence counting sort

    chrono::time_point<chrono::system_clock> endTime = chrono::system_clock::now(); //Stop counting milliseconds
    long elapsedTime = chrono::duration_cast<chrono::nanoseconds>(endTime - startTime).count(); //Determine total number of milliseconds taken to sort

    cout << "\nSorted Array (First 10 elements):\n";
    printArray(10); //Print the first 10 elements of the sorted array

    cout << "\nTime taken for sorting: " << (elapsedTime / 1e6) << " milliseconds"; //Display time taken to sort (in milliseconds)
    return 0;
}//end main
