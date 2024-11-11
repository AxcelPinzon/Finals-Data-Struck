class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    // This function is responsible for merging the two halves of the array after sorting.
    static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;  // Size of the left subarray
        int n2 = r - m;      // Size of the right subarray

        // Create temporary arrays for the left and right subarrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];  // Copy the left subarray elements
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];  // Copy the right subarray elements

        // Merge the temporary arrays back into the original array arr[]

        // Initial indices for the left (i) and right (j) subarrays
        int i = 0, j = 0;

        // Initial index for the merged subarray in arr[]
        int k = l;
        while (i < n1 && j < n2) {
            // Compare elements from both subarrays and put the smaller element in the merged array
            if (L[i] <= R[j]) {
                arr[k] = L[i];  // Place element from left subarray
                i++;
            } else {
                arr[k] = R[j];  // Place element from right subarray
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using merge()
    // This function recursively divides the array into two halves, sorts them, and merges them.
    static void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point to divide the array into two halves
            int m = l + (r - l) / 2;

            // Recursively sort the first half (arr[l..m])
            sort(arr, l, m);

            // Recursively sort the second half (arr[m+1..r])
            sort(arr, m + 1, r);

            // Merge the two sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print the array of size n
    // This function prints all elements of the array 'arr' to the console.
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");  // Print each element followed by a space
        System.out.println();  // Print a new line after the array
    }

    // Driver code to test the Merge Sort implementation
    public static void main(String args[]) {
        // Initialize an unsorted array
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        // Print the original array
        System.out.println("Given array is");
        printArray(arr);

        // Call the sort function to sort the array
        sort(arr, 0, arr.length - 1);

        // Print the sorted array
        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
