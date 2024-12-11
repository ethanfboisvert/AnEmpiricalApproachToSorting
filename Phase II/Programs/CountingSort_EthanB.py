import datetime
import random

"""
Ethan Boisvert
CS699 Professional Seminar
March 9, 2024
File Name: CountingSort_EthanB.py
Program Description: Uses a counting sort algorithm to sort through a set of 100000 elements.
"""

def countingSort(arr):
    size = len(arr)
    output = [0] * size

    # Initialize count array
    count = [0] * size

    # Store the count of each element 
    for m in range(0, size):
        count[arr[m]] += 1

    # Store the cumulative count
    for m in range(1, size):
        count[m] += count[m - 1]

    # Place the elements in output array after finding index of each element in count array
    m = size - 1
    while m >= 0:
        output[count[arr[m]] - 1] = arr[m]
        count[arr[m]] -= 1
        m -= 1
    
    # Return output array
    return output

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

arr = countingSort(arr)

endTime = datetime.datetime.now()
elapsedTime = endTime - startTime
elapsedTime = (elapsedTime.total_seconds() * 1000)

print("Sorted Array (First 10 elements):")
printArray(arr, 10)

print("Time taken for sorting:", elapsedTime, "milliseconds")
    