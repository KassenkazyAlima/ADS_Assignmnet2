//Implement all methods.
//Prevent loops
//Test all methods of MyLinkedList


public class MyLinkedList<T> implements MyList<T> {
    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
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

}
