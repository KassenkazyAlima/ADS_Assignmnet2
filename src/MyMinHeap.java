import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> heap; // Internal arraylist to store heap elements

    // Constructor to initialize the heap as an empty arraylist
    public MyMinHeap() {
        this.heap = new MyArrayList<>();
    }

    // Method to add an element to the heap
    public void add(T item) {
        heap.add(item); // Adding the new item to the end of the heap
        int i = heap.size() - 1; // Index of the newly added item
        while (i > 0) {
            int parent = (i - 1) / 2; // Index of the parent node
            if (heap.get(i).compareTo(heap.get(parent)) >= 0) { // If the item is greater than or equal to its parent, break
                break;
            }
            swap(i, parent); // Swap the item with its parent if it's smaller
            i = parent; // Update the index to the parent
        }
    }

    // Method to extract the minimum element from the heap
    public T extractMin() {
        if (heap.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        T min = heap.get(0); // Minimum element is always at the root
        T last = heap.get(heap.size() - 1); // Last element in the heap
        heap.set(0, last); // Replace the root with the last element
        heap.remove(heap.size() - 1); // Remove the last element
        if (heap.size() > 0) {
            heapify(0); // Heapify the heap to maintain the heap property
        }
        return min; // Return the minimum element
    }

    // Method to peek the minimum element of the heap
    public T peek() {
        if (heap.size() == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0); // Return the root element
    }

    // Method to heapify the heap starting from a given index
    private void heapify(int i) {
        int left = 2 * i + 1; // Index of the left child
        int right = 2 * i + 2; // Index of the right child
        int smallest = i; // Index of the smallest element among i, left, and right
        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left; // Update smallest if left child is smaller
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right; // Update smallest if right child is smaller
        }
        if (smallest != i) { // If the smallest element is not the current root
            swap(i, smallest); // Swap the current root with the smallest child
            heapify(smallest); // Recursively heapify the affected subtree
        }
    }

    // Method to swap two elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i); // Temporary variable to hold the value at index i
        heap.set(i, heap.get(j)); // Set the value at index i to the value at index j
        heap.set(j, temp); // Set the value at index j to the temporary variable
    }

    // Method to get the size of the heap
    public int size() {
        return heap.size(); // Return the size of the heap
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return heap.size() == 0; // Return true if the heap is empty
    }
}
