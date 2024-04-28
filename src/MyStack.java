import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<T>(); // Internal linked list to store stack elements

    // Method to push an element onto the stack
    public void push(T element) {
        list.addLast(element); // Adding elements to the end of the linked list
    }

    // Method to pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = list.getLast(); // Getting the last element from the linked list
        list.removeLast(); // Removing the last element after retrieving it
        return element;
    }

    // Method to peek the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.getLast(); // Peeking at the last element of the linked list
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return list.size() == 0; // Checking if the linked list is empty
    }

    // Method to get the size of the stack
    public int size() {
        return list.size(); // Returning the size of the linked list
    }
}
