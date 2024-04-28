import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<T>();


    public void push(T element) {
        list.addLast(element); //adding elements to the end
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = list.getLast();
        list.removeLast(); //removes the last element after getting it
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.getLast(); //peek the element
    }

    public boolean isEmpty() {
        return list.size() == 0; //empty or not
    }

    public int size() {
        return list.size();
    }
}

