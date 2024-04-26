import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> list = new MyLinkedList<T>();


    public void push(T element) {
        list.addLast(element);
    }


    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T element = list.getLast();
        list.removeLast();
        return element;
    }


    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.getLast();
    }


    public boolean isEmpty() {

        return list.size() == 0;
    }


    public int size() {
        return list.size();
    }
}

