package com.company;

import java.util.Random;

// Alexander G. Lucaci
// References: https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
// Also relied on the Data Structures textbook.

public class Main {
    public static int numComparisons = 0;
    public static long numExchanges = 0;
    public static final Object[][] table = new String[10][];

    public static void RESET() {
        numComparisons = 0;
        numExchanges = 0;
    }

    public static void main(String[] args) {
        System.out.println("Starting.");
        table[0] = new String[] { "# ", " Method ", "  Number of Items", "Comparisons", "Exchanges", "Runtime (ms)", "Winner" };

        // INSERTION SORT (1000)
        long startTime = System.nanoTime();
        System.out.println("\nRunning.. Insertion Sort.");
        run_insertion_sort(1000);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        String s1 = "" + duration/1000000;
        String sComps = "" + numComparisons;
        String sExchs = "" + numExchanges;
        table[1] = new String[] { "1 ", "Insertion Sort", "1000", sComps, sExchs, s1, "" };

        // INSERTION SORT (10000)
        startTime = System.nanoTime();
        RESET();
        run_insertion_sort(10000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[2] = new String[] { "2 ", "Insertion Sort", "10000", sComps, sExchs, s1, "" };

        // INSERTION SORT (100000)
        //System.out.println("IS 3");
        startTime = System.nanoTime();
        RESET();
        run_insertion_sort(100000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[3] = new String[] { "3 ", "Insertion Sort", "100000", sComps, sExchs, s1, "" };

        // QUICK SORT (1000)
        System.out.println("\nRunning.. Quick Sort.");
        startTime = System.nanoTime();
        RESET();
        run_quick_sort(1000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[4] = new String[] { "4 ", "Quick Sort", "1000", sComps, sExchs, s1, "" };

        // QUICK SORT (10000)
        startTime = System.nanoTime();
        RESET();
        run_quick_sort(10000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[5] = new String[] { "5 ", "Quick Sort", "10000", sComps, sExchs, s1, "" };

        // QUICK SORT (100000)
        startTime = System.nanoTime();
        RESET();
        run_quick_sort(100000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[6] = new String[] { "6 ", "Quick Sort", "100000", sComps, sExchs, s1, "" };

        //HEAP SORT (1000)
        System.out.println("\nRunning.. Heap Sort.");
        startTime = System.nanoTime();
        RESET();
        run_heap_sort(1000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[7] = new String[] { "7 ", "Heap Sort", "1000", sComps, sExchs, s1, "" };

        //HEAP SORT (10000)
        startTime = System.nanoTime();
        RESET();
        run_heap_sort(10000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[8] = new String[] { "8 ", "Heap Sort", "10000", sComps, sExchs, s1, "" };

        //HEAP SORT (100000)
        startTime = System.nanoTime();
        RESET();
        run_heap_sort(100000);
        duration = (System.nanoTime() - startTime)/1000000;
        s1 = "" + duration;
        sComps = "" + numComparisons;
        sExchs = "" + numExchanges;
        table[9] = new String[] { "9 ", "Heap Sort", "100000", sComps, sExchs, s1, "" };

        //https://stackoverflow.com/questions/18672643/how-to-print-a-table-of-information-in-java
        System.out.println("\n RESULTS:");
        for (final Object[] row : table) {
            System.out.format("%15s%15s%15s%15s%15s%15s%15s\n", row);
        }
    }

    // --- RUNNER METHODS
    public static void run_heap_sort(int size) {
        int IntArray[] = RandomIntList(size);
        RESET();
        HEAPSORT(IntArray);

    }

    public static void run_quick_sort(int size) {
        int IntArray[] = RandomIntList(size);
        RESET();

        int numItems = IntArray.length;
        QUICKSORT(IntArray, 0, numItems-1);
    }

    public static void run_insertion_sort(int size) {
        long startTime = System.nanoTime();
        int arr[] = RandomIntList(size);
        RESET();

        INSERTION_SORT(arr);
    }

    // --- SORTING METHODS
    public static void INSERTION_SORT(int ArrayInt[]) {
        int n = ArrayInt.length;
        int CurrentKey = 0;
        int j = 0;

        if (n == 0 || n < 0) {
            return;
        }

        for (int i = 1; i < n; i++) {
            CurrentKey = ArrayInt[i];
            j = i - 1;
            //key = arr[i]
            numComparisons += 1;

            while (j >= 0 && ArrayInt[j] > CurrentKey) {
                numExchanges += 1;
                ArrayInt[j + 1] = ArrayInt[j];
                j = j - 1;
            }

            ArrayInt[j + 1] = CurrentKey;
        }
    }

    public static void QUICKSORT(int IntArray[], int lowRange, int highRange) {
        numComparisons += 1;
        if (lowRange < highRange)  {
            int index = partition(IntArray, lowRange, highRange); // set the index
            numExchanges += 1;
            QUICKSORT(IntArray, lowRange, index-1); // Sort before index
            numExchanges += 1;
            QUICKSORT(IntArray, index+1, highRange); // sort after index
        }
    }

    public static void HEAPSORT(int IntArray[]) {
        int numItems = IntArray.length;

        // Build Heap
        for (int i = numItems / 2 - 1; i >= 0; i--)
            MakeHeap(IntArray, numItems, i);

        // Move small items
        for (int i=numItems-1; i>=0; i--) {
            int holder = IntArray[0];
            IntArray[0] = IntArray[i];
            numExchanges += 1;
            IntArray[i] = holder; // Move current to end
            numExchanges += 1;

            // Reduce the heap
            MakeHeap(IntArray, i, 0);
        }
    }

    // --- HELPER FUNCTIONS
    public static void MakeHeap(int IntArray[], int numItems, int i) {
        int MAX = i; // Set Root
        int left = 2*i + 1; // The Left = 2*i + 1
        int right = 2*i + 2; // The Right = 2*i + 2

        numComparisons += 2;
        if (left < numItems && IntArray[left] > IntArray[MAX]) {
            MAX = left;
        } else if (right < numItems && IntArray[right] > IntArray[MAX]) {
            MAX = right;
        }

        if (MAX != i) {
            int swap = IntArray[i];
            IntArray[i] = IntArray[MAX];
            IntArray[MAX] = swap;
            numExchanges += 1;
            MakeHeap(IntArray, numItems, MAX); // Recursive
        }
    }

    //Pivot, and partition
    public static int partition(int IntArray[], int lowRange, int highRange) {
        int pivot = IntArray[highRange];
        int i = (lowRange - 1); // smaller element

        for (int j = lowRange; j < highRange; j++) { // run through
            numComparisons += 1;
            if (IntArray[j] < pivot) {
                i++;

                // Exchanges...
                int temp = IntArray[i];
                IntArray[i] = IntArray[j];
                IntArray[j] = temp;
                numExchanges += 2;
            }
        } // exit for

        // Pivot
        int temp = IntArray[i + 1];
        IntArray[i + 1] = IntArray[highRange];
        IntArray[highRange] = temp;
        numExchanges += 2;

        return i + 1;
    }

    public static void PRINTOUT(int TheArray[]) {
        // Assumes Integer List input.
        int numItems = TheArray.length;

        for (int i=0; i < numItems; i++) {
            System.out.print(TheArray[i] + " ");
        }
        //extra line
        System.out.println();
    }

    public static int[] RandomIntList(int size) {
        Random r = new Random();
        int max = size;
        int IntArray[] = new int[max];

        for (int a = 0; a < max; a++) {
            //arr[a] = max - (a + 1);
            IntArray[a] = r.nextInt(max);
            //System.out.println(IntArray[a]);
        }
        return IntArray;
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