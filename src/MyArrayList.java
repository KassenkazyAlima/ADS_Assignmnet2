//Implement all methods
//Test all methods of MyArrayList

public class MyArrayList<T> {
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

    public T get(int index){
        return (T) arr[index]; //to get (print) the value by index. In order to access the data
    }

    public void add(T newItem){ //adding element
        if( size == capacity){ // checking if the size is equal to capacity.
            increaseBuffer();
        }
        arr[size++] = newItem; //if not, then just insert the element to our array
        // arr[0] = 56
    }
/
    public void increaseBuffer(){
        capacity = (int) (1.5 * capacity); // formula designed by programmer. increase
        Object[] arr2 = new Object[capacity]; // new capacity
        for(int i = 0; i<size; i++){
            arr2[i] = arr[i];
        }
        arr = arr2;
    }
    public int getSize() {
        return size;
    }
    public iterator<T> iterator(){
        return new MyIterator();
    }

    public void addElement(int i) {
    }

    public class MyIterator implements iterable<T>{
        int cursr
    }


}