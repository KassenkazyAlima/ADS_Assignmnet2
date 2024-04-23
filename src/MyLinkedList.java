//Implement all methods.
//Prevent loops
//Test all methods of MyLinkedList
/

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;//

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {

    }

    @Override
    public void set(int index, T item) {

    }

    @Override
    public void add(int index, T item) {

    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    public T get(int index){
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = head;
        for(int i =0; i<index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        return 0;
    }

    @Override
    public boolean exists(Object object) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
