class QuickSort {

    // Partition function
    // This function takes the last element as the pivot, places it in the correct position,
    // and places all smaller elements before it and larger elements after it.
    static int partition(int[] arr, int low, int high) {
        
        // Choose the pivot element (here, we choose the last element as pivot)
        int pivot = arr[high];
        
        // 'i' is the index of the smaller element and indicates the right position of the pivot found so far
        int i = low - 1;

        // Traverse arr[low..high-1], comparing each element with the pivot
        // If the element is smaller than the pivot, move it to the left side
        // Elements from arr[low] to arr[i] are smaller after each iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {  // If current element is smaller than the pivot
                i++;  // Increment the index of the smaller element
                swap(arr, i, j);  // Swap arr[i] and arr[j] to move smaller element to the left
            }
        }
        
        // Swap arr[i + 1] and arr[high] to place the pivot in its correct position
        // Elements smaller than pivot are on the left and larger elements on the right
        swap(arr, i + 1, high);
        
        // Return the pivot's index after it has been placed in the correct position
        return i + 1;
    }

    // Swap function
    // This function swaps two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];  // Store arr[i] in a temporary variable
        arr[i] = arr[j];    // Move arr[j] to arr[i]
        arr[j] = temp;      // Move the stored arr[i] to arr[j]
    }

    // The QuickSort function implementation
    // This function recursively sorts the array by partitioning it around a pivot
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition index, the position of the pivot
            int pi = partition(arr, low, high);

            // Recursively sort the left and right parts of the array
            quickSort(arr, low, pi - 1);  // Sort elements before the pivot
            quickSort(arr, pi + 1, high); // Sort elements after the pivot
        }
    }

    // Main function - entry point for the program
    // Initializes an array, calls quickSort, and prints the sorted array
    public static void main(String[] args) {
        // Example array to be sorted
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
      
        // Call quickSort to sort the entire array
        quickSort(arr, 0, n - 1);
        
        // Print the sorted array
        System.out.println("Sorted Array: ");
        for (int val : arr) {
            System.out.print(val + " ");  // Print each element followed by a space
        }
    }
}
