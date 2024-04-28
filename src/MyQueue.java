import java.util.NoSuchElementException;

public class MyQueue<T> {
    private final MyLinkedList<T> list = new MyLinkedList<T>();

    public void enqueue(T element){
        list.addLast(element);
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        T element = list.removeFirst();
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.getFirst();
    }

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }
}
