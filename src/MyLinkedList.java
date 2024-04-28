import java.util.Iterator;
import java.util.NoSuchElementException;

import static sun.util.locale.LocaleUtils.isEmpty;


public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {

    // Node class for the elements of the linked list
    private static class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
        T data;
        ListNode<T> next;
        ListNode<T> prev;

        // Constructors for ListNode class
        ListNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        ListNode(T data, ListNode<T> next, ListNode<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        // Method to compare nodes
        @Override
        public int compareTo(ListNode<T> other) {
            return this.data.compareTo(other.data);
        }
    }

    // Head and tail pointers of the linked list
    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    // Method to add an element to the end of the list
    @Override
    public void add(T item) {
        if (head == null) {
            head = new ListNode<>(item);
            tail = head;
        } else {
            ListNode<T> newNode = new ListNode<>(item, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to set an element at a specific index
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> current = getNodeAtIndex(index);
        current.data = item;
    }

    // Method to add an element at a specific index
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            ListNode<T> current = getNodeAtIndex(index);
            ListNode<T> newNode = new ListNode<>(item, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    // Method to add an element at the beginning of the list
    @Override
    public void addFirst(T item) {
        ListNode<T> newNode = new ListNode<>(item, head, null);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    // Method to add an element at the end of the list
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Method to get the element at a specific index
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListNode<T> current = getNodeAtIndex(index);
        return current.data;
    }

    // Method to get the first element of the list
    @Override
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    // Method to get the last element of the list
    @Override
    public T getLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    // Method to remove an element at a specific index
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        ListNode<T> current = getNodeAtIndex(index);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;
        size--;
    }

    // Method to remove the first element of the list
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T element = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return element; // Return the removed element
    }




    // Method to remove the last element of the list
    @Override
    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        ListNode<T> prevNode = tail.prev;
        if (prevNode != null) {
            prevNode.next = null;
        } else {
            head = null;
        }
        tail.prev = null;
        tail = prevNode;
        size--;
    }

    // Method to sort the elements of the list
    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        Object[] dataArray = toArray();
        Arrays.sort(dataArray);
        clear();
        for (Object item : dataArray) {
            add((T) item);
        }
    }

    // Method to find the index of a specified object
    @Override
    public int indexOf(Object object) {
        int index = 0;
        ListNode<T> current = head;
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.next;
                index++;
            }
        } else {
            while (current != null) {
                if (object.equals(current.data)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    // Method to find the last index of a specified object
    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        ListNode<T> current = tail;
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        } else {
            while (current != null) {
                if (object.equals(current.data)) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        }
        return -1;
    }

    // Method to check if a specified object exists in the list
    @Override
    public boolean exists(Object object) {
        ListNode<T> current = head;
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            while (current != null) {
                if (object.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
}

