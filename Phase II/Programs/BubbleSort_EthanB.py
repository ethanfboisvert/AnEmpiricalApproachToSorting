import datetime
import random

"""
Ethan Boisvert
CS699 Professional Seminar
March 9, 2024
File Name: BubbleSort_EthanB.py
Program Description: Uses a bubble sort algorithm to sort through a set of 100000 elements.
"""

def bubbleSort(arr):
    size = len(arr)
    swapped = False
    
    # Search through all array elements
    for i in range(size):
        swapped = False
        for j in range(0, size - i - 1):
            # print(i, " ", j)
            # Swap two elements if a greater element is found
            if arr[j] > arr[j + 1]:
                swapped = True
                # arr[j], arr[j + 1] = arr[j + 1], arr[j]
                temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                
        if not swapped: # Break loop if elements were not swapped
            return # arr # Return output array

def generateRandomArray(size):
    random.seed(555)
    arr = []
    for i in range(0, size):
        arr.append(random.randrange(0, size))
    return arr

def printArray(arr, n):
    strng = ""
    for i in range(0, n):
        strng = strng + str(arr[i]) + " "
    print(strng, "...")

arraySize = 100000
arr = generateRandomArray(arraySize)

print("Set size:", arraySize, "elements")
print("Original Array (First 10 elements):")
printArray(arr, 10)

startTime = datetime.datetime.now()

bubbleSort(arr)

endTime = datetime.datetime.now()
elapsedTime = endTime - startTime
elapsedTime = (elapsedTime.total_seconds() * 1000)

print("Sorted Array (First 10 elements):")
printArray(arr, 10)

print("Time taken for sorting:", elapsedTime, "milliseconds")
    