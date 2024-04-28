import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements MyList<T> {
    private Object[] arr; // Array to store elements
    private int size = 0; // Number of elements currently stored
    private int capacity = 10; // Initial capacity of the array

    // Default constructor
    public MyArrayList() {
        arr = new Object[capacity]; // Initialize array with default capacity
    }

    // Constructor with initial capacity
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity " + initialCapacity);
        }
        arr = new Object[initialCapacity]; // Initialize array with specified capacity
    }

    // Get element at index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arr[index];
    }

    // Add element to the end of the list
    @Override
    public void add(T item) {
        if (size == arr.length) { // Check if array is full
            increaseCapacity(); // Increase capacity if necessary
        }
        arr[size++] = item; // Add item at the end of the list
    }

    // Increase capacity of the array
    private void increaseCapacity() {
        int newCapacity = arr.length * 2; // Double the current capacity
        Object[] newArr = new Object[newCapacity]; // Create a new array with increased capacity
        System.arraycopy(arr, 0, newArr, 0, size); // Copy elements to the new array
        arr = newArr; // Update reference to the new array
    }

    // Set element at index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }

    // Add element at specific index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) { // Check if array is full
            increaseCapacity(); // Increase capacity if necessary
        }
        for (int i = size; i > index; i--) { // Shift elements to make space for new element
            arr[i] = arr[i - 1];
        }
        arr[index] = item; // Insert new element at the specified index
        size++; // Increment size
    }

    // Add element at the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Add element at the end of the list
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Get the first element of the list
    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return get(0);
    }

    // Get the last element of the list
    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return get(size - 1);
    }

    // Remove element at specific index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) { // Shift elements to remove the element at the specified index
            arr[i] = arr[i + 1];
        }
        size--; // Decrement size
    }

    // Remove the first element of the list
    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        remove(0);
    }

    // Remove the last element of the list
    @Override
    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        remove(size - 1);
    }

    // Sort the elements of the list
    @Override
    public void sort() {
        // Assuming T is comparable
        java.util.Arrays.sort((T[]) arr, 0, size);
    }

    // Find the index of a specified object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Find the last index of a specified object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
}

