public class MyLinkedList {
    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList(){

    }
    public int get(int index){
        MyNode current = head;
        for(int i =0; i<index; i++){
            current = current.next;
        }
    }

}
