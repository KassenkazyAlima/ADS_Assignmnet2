import java.util.ArrayList;

public class MyArrayList {
    private int[] arr;
    private int size;

    public void ArrayList(){
        arr = new int[5];
        size = 0;
    }
    public void addElement(int element){
        if(size > arr.length){
            increaseBuffer();
        }
        arr[size++] = element;
    }

    public void addElement(int element, int index){
        checkIndex(index);
        if ( size >= arr.length){
            increaseBuffer();
        }
        arr[index] = element;
    }
    private void increaseBuffer(){
        int[] newArr = new int[arr.length *2];
        for (int i =0; i<arr.length;i++){
            newArr[i] = arr[i];

        }
        arr = newArr;
    }

    //to get the element
    public int getElement(int index){
        checkIndex(index);
        return arr[index];
    }
    public int getsize(){
        return size;
    }

    public void removeElement(int index){
        checkIndex(index);
        for (int i = index; i<size ; i++){
            arr[i--] = arr[i];
        }
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException("index not correct");
        } //
    }
    private void checkID(){
        return 0
    }
}

// created new array, and we also have a old array