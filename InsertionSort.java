public class InsertionSort {

    /* Function to sort array using insertion sort */
    // The 'sort' method sorts the input array 'arr' using the Insertion Sort algorithm.
    // Insertion Sort works by iterating through the array and "inserting" each element into
    // its correct position within the already sorted portion of the array (on the left).
    void sort(int arr[]) {
        int n = arr.length;  // Get the length of the array

        // Iterate over the array starting from the second element (index 1)
        for (int i = 1; i < n; ++i) {
            int key = arr[i];  // The element to be placed at the correct position
            int j = i - 1;  // j will be used to compare the elements to the left of the current element

            // Move elements of arr[0..i-1], that are greater than the key, one position ahead of their current position
            // This makes space for the 'key' to be inserted in its correct position.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];  // Shift the element to the right
                j = j - 1;  // Move the index j to the left to continue comparing
            }
            arr[j + 1] = key;  // Place the key at its correct position in the sorted portion of the array
        }
    }

    /* A utility function to print array of size n */
    // The 'printArray' method prints the elements of the input array 'arr' to the console.
    static void printArray(int arr[]) {
        int n = arr.length;  // Get the length of the array

        // Loop through the array and print each element
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");  // Print each element followed by a space
        }
        System.out.println();  // Print a new line after printing the array
    }

    // Driver method
    // The 'main' method serves as the entry point to the program.
    // It creates an array, sorts it using Insertion Sort, and then prints the sorted array.
    public static void main(String args[]) {
        // Initialize an unsorted array
        int arr[] = { 12, 11, 13, 5, 6 };

        // Create an instance of InsertionSort
        InsertionSort ob = new InsertionSort();

        // Call the sort function to sort the array
        ob.sort(arr);

        // Call printArray to print the sorted array
        System.out.println("Sorter Array:");
        printArray(arr);
    }
}
