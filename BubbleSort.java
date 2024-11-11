class Bubble {

    // An optimized version of Bubble Sort
    // This function sorts the array 'arr' of size 'n' using the Bubble Sort algorithm.
    // It includes an optimization where if no elements were swapped in a full pass,
    // the algorithm terminates early.
    static void bubbleSort(int arr[], int n) {
        int i, j, temp;
        boolean swapped;  // Flag to check if a swap occurred during a pass

        // Outer loop: Iterate through all elements in the array
        for (i = 0; i < n - 1; i++) {
            swapped = false; // Reset the swapped flag at the start of each outer loop iteration

            // Inner loop: Compare each pair of adjacent elements and swap if necessary
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j + 1] if they are in the wrong order
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;  // Set swapped to true indicating a change was made
                }
            }

            // If no two elements were swapped during the inner loop, the array is already sorted
            // So, break the outer loop early for optimization
            if (!swapped) {
                break;
            }
        }
    }

    // Function to print an array
    // This function prints all elements of the array 'arr' with the size 'size'
    static void printArray(int arr[], int size) {
        int i;
        
        // Loop through the array and print each element
        for (i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");  // Print each element followed by a space
        }
        System.out.println();  // Print a new line after the array is printed
    }

    // Main method: Entry point of the program
    // It initializes an array, sorts it using bubbleSort, and then prints the sorted array
    public static void main(String args[]) {
        // Initialize the array with some unsorted values
        int arr[] = { 64, 34, 25, 12, 22, 11, 90, 100, 45, 35, 20 };

        // Get the length of the array
        int n = arr.length;

        // Call bubbleSort to sort the array
        bubbleSort(arr, n);

        // Print the sorted array
        System.out.println(" Your Sorted array: ");
        printArray(arr, n);
    }
}