//Implement all methods
//Test all methods of MyArrayList
import java.util.Iterator;

public class MyArrayList<T>  implements MyList<T>{
    private Object[] arr; //in order to hold the elements of the list
    private int size = 0; // size - number of elements
    private int capacity = 5; // capacity

    public MyArrayList(){
        arr = new Object[capacity];
        /* declaration, integer with capacity of 5.
        In the main class, if we want to create instance for MyArraylist,
        we need to call the instructor.
         */
    }

    public MyArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Illegral Capacity " + initialCapacity);
        }
        arr = new Object[initialCapacity];
    }
    public MyArrayList(Object[] items){
        arr = items;
        size = items.length;
    }

    public MyArrayList(MyArrayList<T> list){
        arr = list.arr;
        size = list.size;
    }
    @Override
    public T get(int index){
        return (T) arr[index]; //to get (print) the value by index. In order to access the data
    }
    @Override
    public void add(T newItem){ //adding element
        if( size == capacity){ // checking if the size is equal to capacity.
            increaseBuffer();
        }
        arr[size++] = newItem;
        size++;//if not, then just insert the element to our array
        // arr[0] = 56
    }
    public void increaseBuffer(){
        Object[] newArr = (T[]) new Object[arr.length *2];
        for (int i =0; i<arr.length;i++){
            newArr[i] = (T) arr[i];

        }
        arr = newArr;
    }

    @Override
    public void set(int index, T item){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = item;
    }


    @Override
    public void add(int index, T item) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(size = arr.length) {
            T[] newArr = (T[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
        size++;

    }

    @Override
    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[0];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[size - 1];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

    }

    @Override
    public void removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        size--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (((Comparable<T>) arr[i]).compareTo(arr[j]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        // Use System.arraycopy for better performance when copying elements.
        System.arraycopy(arr, 0, arr, 0, size);
        return arr;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }







    @Override
    public void addFirst(T item) {
        add(0,item);

    }

    @Override
    public void addLast(T item) {
        add(item);

    }

    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    public void addElement(int i) {
    }

    

}