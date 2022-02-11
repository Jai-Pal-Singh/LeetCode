package kth_largest_element_in_an_array;

public class MinHeap {
    int[] harr; // pointer to array of elements in heap
    int capacity; // maximum possible size of min heap
    int heapSize; // Current number of elements in min heap

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return ((2 * i) + 1);
    }

    int right(int i) {
        return ((2 * i) + 2);
    }

    int getMin() {
        return harr[0];
    } // Returns minimum

    // to replace root with new node x and heapify() new root
    void replaceMax(int x) {
        this.harr[0] = x;
        minHeapify(0);
    }

    MinHeap(int[] a, int size) {
        heapSize = size;
        harr = a; // store address of array
        int i = (heapSize - 1) / 2;
        while (i >= 0) {
            minHeapify(i);
            i--;
        }
    }

    // Method to remove maximum element (or root) from min heap
    int extractMin() {
        if (heapSize == 0)
            return Integer.MAX_VALUE;

        // Store the maximum value.
        int root = harr[0];

        // If there are more than 1 items, move the last item to root
        // and call heapify.
        if (heapSize > 1) {
            harr[0] = harr[heapSize - 1];
            minHeapify(0);
        }
        heapSize--;
        return root;
    }

    // A recursive method to heapify a subtree with root at given index
    // This method assumes that the subtrees are already heapified
    void minHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heapSize && harr[l] < harr[i])
            smallest = l;
        if (r < heapSize && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            int t = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = t;
            minHeapify(smallest);
        }
    }
}
