# ADS_Assignmnet2

This file provides an overview of my project, including instructions such as building, testing, and running the code.  This project implements various data structures including ArrayList, LinkedList, Stack, Queue, and MinHeap without using built-in Java utilities.


The project consists of the following main components:

MyArrayList: An implementation of ArrayList data structure.

MyLinkedList: An implementation of LinkedList data structure.

MySatck: An implementation of Stack data structure using MyLinkedList.

MyQueue: An implementation of Queue data structure using MyLinkedList.

MyMinHeap: An implementation of MinHeap data structure using MyArrayList.

Each data structure class (MyArrayList, MyLinkedList, MyStack, MyQueue, MyMinHeap) contains various methods for adding, removing, and manipulating elements. Refer to the Javadoc comments in the source code for detailed information on each method.


MyArrayList (fields : array, size). Methods include 
void add(T item) -  Adds the specified element to the end of the list.
void set(int index, T item) - Replaces the element at the specified position in the list with the specified element.
void add(int index, T item) -  Inserts the specified element at the specified position in the list.
void addFirst(T item) - Inserts the specified element at the beginning of the list.
void addLast(T item) - Appends the specified element to the end of the list.
T get(int index) - Returns the element at the specified position in the list
T getFirst() - Returns the first element in the list.
T getLastoi void remove(int index) - Removes the element at the specified position in the list.
void removeFirst() - Removes the first element from the list.
void removeLast() - Removes the last element from the list
void sort() - Sorts the elements of the list in ascending order.
int indexof(Obiect obiect) - Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
int lastIndex0f(Object object) - Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
boolean exists(Object object)- Checks whether the list contains the specified element.
public Objectl] toArray() - Returns an array containing all of the elements in the list in proper sequence.
void clear() - Removes all of the elements from the list.
int size() -Returns the number of elements in the list.


MyLinkedList (fields: head,tail,size)
MyArrayList (fields : array, size). Methods include 
void add(T item) -  Adds the specified element to the end of the list.
void set(int index, T item) - Replaces the element at the specified position in the list with the specified element.
void add(int index, T item) -  Inserts the specified element at the specified position in the list.
void addFirst(T item) - Inserts the specified element at the beginning of the list.
void addLast(T item) - Appends the specified element to the end of the list.
T get(int index) - Returns the element at the specified position in the list
T getFirst() - Returns the first element in the list.
T getLastoi void remove(int index) - Removes the element at the specified position in the list.
void removeFirst() - Removes the first element from the list.
void removeLast() - Removes the last element from the list
void sort() - Sorts the elements of the list in ascending order.
int indexof(Obiect obiect) - Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
int lastIndex0f(Object object) - Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
boolean exists(Object object)- Checks whether the list contains the specified element.
public Objectl] toArray() - Returns an array containing all of the elements in the list in proper sequence.
void clear() - Removes all of the elements from the list.
int size() -Returns the number of elements in the list.


MyList interface contains:
MyArrayList (fields : array, size). Methods include 
void add(T item) -  Adds the specified element to the end of the list.
void set(int index, T item) - Replaces the element at the specified position in the list with the specified element.
void add(int index, T item) -  Inserts the specified element at the specified position in the list.
void addFirst(T item) - Inserts the specified element at the beginning of the list.
void addLast(T item) - Appends the specified element to the end of the list.
T get(int index) - Returns the element at the specified position in the list
T getFirst() - Returns the first element in the list.
T getLastoi void remove(int index) - Removes the element at the specified position in the list.
void removeFirst() - Removes the first element from the list.
void removeLast() - Removes the last element from the list
void sort() - Sorts the elements of the list in ascending order.
int indexof(Obiect obiect) - Returns the index of the first occurrence of the specified element in the list, or -1 if the list does not contain the element.
int lastIndex0f(Object object) - Returns the index of the last occurrence of the specified element in the list, or -1 if the list does not contain the element.
boolean exists(Object object)- Checks whether the list contains the specified element.
public Objectl] toArray() - Returns an array containing all of the elements in the list in proper sequence.
void clear() - Removes all of the elements from the list.
int size() -Returns the number of elements in the list.



MyStack (field: list)
It contains:
push(T element): Adds an element to the top of the stack.
pop(): Removes and returns the element at the top of the stack.
peek(): Returns the element at the top of the stack without removing it.
isEmpty(): Checks if the stack is empty.
size(): Returns the number of elements in the stack.


MyQueue (field: list)
It contains:
enqueue(T element): Adds an element to the end of the queue.
dequeue(): Removes and returns the element at the front of the queue.
peek(): Returns the element at the front of the queue without removing it.
isEmpty(): Checks if the queue is empty.
size(): Returns the number of elements in the queue.



MyMinHeap(field:heap)
It contains: 
add(T item): Adds an item to the min-heap while maintaining the heap property.
extractMin(): Removes and returns the minimum element from the min-heap, maintaining the heap property.
peek(): Returns the minimum element in the min-heap without removing it.
heapify(int i): Adjusts the heap structure starting from the given index to maintain the heap property.
swap(int i, int j): Swaps the elements at the given indices in the heap.
size(): Returns the number of elements in the min-heap.
isEmpty(): Checks if the min-heap is empty.


