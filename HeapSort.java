class HeapSort {

    // To heapify a subtree rooted with node i, which is an index in arr[].
    // This function ensures that the subtree rooted at index i follows the heap property.
    static void heapify(int arr[], int n, int i) {

        // Initialize largest as root
        int largest = i; 

        // left index = 2*i + 1 (left child of node i)
        int l = 2 * i + 1; 

        // right index = 2*i + 2 (right child of node i)
        int r = 2 * i + 2;

        // If left child is larger than root, update largest
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far, update largest
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root, swap and recursively heapify the affected subtree
        if (largest != i) {
            // Swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Main function to do heap sort
    // The heapSort function first builds a max-heap and then extracts elements one by one,
    // maintaining the heap property during each extraction.
    static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build a max-heap (rearrange the array into a heap)
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: One by one extract elements from the heap
        for (int i = n - 1; i > 0; i--) {

            // Move current root (maximum element) to the end
            int temp = arr[0]; 
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap to restore the heap property
            heapify(arr, i, 0);
        }
    }

    // A utility function to print the array of size n
    // This function prints all the elements in the array.
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");  // Print each element followed by a space
        }
        System.out.println();  // Print a new line after the array is printed
    }

    // Driver code - entry point of the program
    public static void main(String args[]) {
        // Example unsorted array
        int arr[] = {9, 4, 3, 8, 10, 2, 5}; 

        // Call heapSort to sort the array
        heapSort(arr);

        // Print the sorted array
        System.out.println("Sorted array is ");
        printArray(arr);
    }
}
