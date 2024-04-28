import java.util.NoSuchElementException;

public class MyQueue<T extends Comparable<T>> {
    private final MyLinkedList<T> list = new MyLinkedList<T>(); // Internal linked list for the queue

    // Method to enqueue (add) an element to the queue
    public void enqueue(T element){
        list.addLast(element); // Add the element to the end of the queue
    }

    // Method to dequeue (remove) an element from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        // Remove and return the dequeued element
        return list.removeFirst();
    }


    // Method to peek (retrieve) the element at the front of the queue without removing it
    public T peek() {
        if (isEmpty()) { // Check if the queue is empty
            throw new NoSuchElementException("Queue is empty"); // Throw an exception if the queue is empty
        }
        return list.getFirst(); // Return the element at the front of the queue
    }

    // Method to check if the queue is empty
    public boolean isEmpty(){
        return list.size() == 0; // Return true if the queue is empty, false otherwise
    }

    // Method to get the size of the queue
    public int size(){
        return list.size(); // Return the number of elements in the queue
    }
}
