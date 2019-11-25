package com.company;

import java.util.Random;

// Alexander G. Lucaci
// References: https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
public class Main {

    //int arr[] = { 12, 11, 13, 5, 6 };
    public static int numComparisons = 0;
    public static int numExchanges = 0;
    public static final Object[][] table = new String[10][];
    public static void main(String[] args) {
	// write your code here
        System.out.println("Starting.");
        //System.out.print("\n LENGTH " + BLAH.length + "\n");
        //System.out.print(BLAH[9997]);
        //System.out.print(BLAH[9998]);
        //System.out.print(BLAH[9999]);

        //System.out.print(BLAH);
        //PRINTOUT(BLAH);

        // INSERTION SORT
        long startTime = System.nanoTime();
        System.out.println("\nInsertion Sort.");
        run_insertion_sort();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("METHOD RUNTIME: " + duration/1000000 + " ms");
        System.out.println("Comparisons: " + numComparisons);
        System.out.println("Exchanges: " + numExchanges);

        // QUICK SORT
        startTime = System.nanoTime();
        numComparisons = 0;
        numExchanges = 0;
        System.out.println("\nQuick Sort.");
        run_quick_sort();
        System.out.println("METHOD RUNTIME: " + (endTime - System.nanoTime())/1000000 + " ms");
        System.out.println("Comparisons: " + numComparisons);
        System.out.println("Exchanges: " + numExchanges);

        //HEAP SORT
        startTime = System.nanoTime();
        numComparisons = 0;
        numExchanges = 0;
        System.out.println("\nHeap Sort.");
        run_heap_sort();
        System.out.println("METHOD RUNTIME: " + (endTime - System.nanoTime())/1000000 + " ms");
        System.out.println("Comparisons: " + numComparisons);
        System.out.println("Exchanges: " + numExchanges);

        //https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java
        System.out.println("\n RESULTS:");
        //final Object[][] table = new String[10][];
        table[0] = new String[] { "# ", " Method ", "  Number of Items", "Runtime (ms)", "Winner" };
        table[1] = new String[] { "1 ", "Insertion Sort", "1000", "X", "" };
        table[2] = new String[] { "2 ", "Insertion Sort", "10000", "X", "" };
        table[3] = new String[] { "3 ", "Insertion Sort", "100000", "X", "" };
        table[4] = new String[] { "4 ", "Quick Sort", "1000", "X", "" };
        table[5] = new String[] { "5 ", "Quick Sort", "10000", "X", "" };
        table[6] = new String[] { "6 ", "Quick Sort", "100000", "X", "" };
        table[7] = new String[] { "7 ", "Heap Sort", "1000", "X" , ""};
        table[8] = new String[] { "8 ", "Heap Sort", "10000", "X" , ""};
        table[9] = new String[] { "9 ", "Heap Sort", "100000", "X" , ""};

        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s\n", row);
        }
    }

    // RUNNER METHODS
    public static void run_heap_sort() {
        int arr[] = { 12, 11, 13, 5, 6, 23, 666, 9090, 1001, 4, 2, 1, 78, 79, 80, 55, 54, 53, 52 , 51};

        HEAPSORT(arr);

        //Print integer list
        PRINTOUT(arr);
    }

    public static void run_quick_sort() {
        int arr[] = { 12, 11, 13, 5, 6, 23, 666, 9090, 1001, 4, 2, 1, 78, 79, 80};
        int n = arr.length;
        QUICKSORT(arr, 0, n-1);

        //Print integer list
        PRINTOUT(arr);
    }

    public static void run_insertion_sort() {
        //int arr[] = { 12, 11, 13, 5, 6, 23, 666, 9090, 1001, 4, 2, 1};

        Random r = new Random();
        int max = 10000;
        int arr[] = new int[max];

        for (int a = 0; a < max; a++) {
            //arr[a] = max - (a + 1);
            arr[a] = r.nextInt(max);
            System.out.println(arr[a]);
        }


        //int arr[] = n
        INSERTION_SORT(arr);
        //System.out.println(arr);
        int n = arr.length;

        //Print integer list
        PRINTOUT(arr);
    }

    // SORTING METHODS
    public static void INSERTION_SORT(int ArrayInt[]) {
        int n = ArrayInt.length;
        int key = 0;
        int j = 0;

        if (n == 0 || n < 0) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            key = ArrayInt[i];
            j = i - 1;
            //key = arr[i]
            numComparisons += 1;

            while (j >= 0 && ArrayInt[j] > key) {
                numExchanges += 1;
                ArrayInt[j + 1] = ArrayInt[j];
                j = j - 1;
            }

            ArrayInt[j + 1] = key;
        }
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void QUICKSORT(int arr[], int low, int high) {
        numComparisons += 1;
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            numExchanges += 1;
            QUICKSORT(arr, low, pi-1);
            numExchanges += 1;
            QUICKSORT(arr, pi+1, high);
        }
    }

    public static void HEAPSORT(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)  {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            numExchanges += 1;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }


    // HELPER FUNCTIONS
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        numComparisons += 1;
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        numComparisons += 1;
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        numComparisons += 1;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            numExchanges += 1;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* This function takes last element as pivot,
   places the pivot element at its correct
   position in sorted array, and places all
   smaller (smaller than pivot) to left of
   pivot and all greater elements to right
   of pivot */
    public static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)  {
            // If current element is smaller than the pivot
            numComparisons += 1;
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                numExchanges += 1;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        numExchanges += 1;

        return i+1;
    }

    public static void PRINTOUT(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}

/* END OF FILE */


// --- Sorting

// 1 --- Implement:
// Insertion Sort
// Quick Sort
// Heapsort



// Keep track of runtime of the algo.
// Number of comparisons
// Here, a comparison is whenever we are checking to see if two items
//  are out of order. It does not include checking to see if we're out of
//  bounds or anything index related.

// The number of exchanges.
//  Whenever two items get swapped or an item gets copied or moved,
//  that's an exchange.