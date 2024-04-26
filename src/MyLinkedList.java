package week6Laboratory2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class ListNode<T extends Comparable<T>> implements Comparable<ListNode<T>> {
        T data;
        ListNode<T> next;
        ListNode<T> prev;

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

        @Override
        public int compareTo(ListNode<T> other) {

            return this.data.compareTo(other.data);
        }
    }


    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

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

    @Override
    public void set(int index, T item) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }


        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }


        current.data = item;
    }

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

            ListNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            ListNode<T> newNode = new ListNode<>(item, current, current.prev);
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

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

    @Override
    public void addLast(T item) {

        add(item);
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListNode<T> current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    @Override
    public T getFirst() {

        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T getLast() {

        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

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


        ListNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }


        ListNode<T> nextNode = head.next;

        if (nextNode != null) {
            nextNode.prev = null;
        } else {

            tail = null;
        }

        head.next = null;
        head = nextNode;

        size--;
    }

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

    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }

        ListNode<T> sorted = new ListNode<>(null); // Dummy head

        while (head != null) {
            ListNode<T> current = head;
            head = head.next;

            ListNode<T> sortedCurrent = sorted;
            while (sortedCurrent.next != null && sortedCurrent.next.data.compareTo(current.data) < 0) {
                sortedCurrent = sortedCurrent.next;
            }
            current.next = sortedCurrent.next;
            if (sortedCurrent.next != null) {
                sortedCurrent.next.prev = current;
            }
            sortedCurrent.next = current;
            current.prev = sortedCurrent;


            if (sortedCurrent == tail || tail == null) {
                tail = current;
            }
        }

        head = sorted.next;
        if (head != null) {
            head.prev = null;
        }
    }

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


    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        ListNode<T> current = tail;

        // If the object is null, look for a null element from the end of the list.
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        } else {
            // If the object is not null, look for an element equal to the object from the end.
            while (current != null) {
                if (object.equals(current.data)) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        }
        return -1; // Return -1 if the object is not found.
    }


    @Override
    public boolean exists(Object object) {
        ListNode<T> current = head;

        // If the object is null, look for a null element in the list.
        if (object == null) {
            while (current != null) {
                if (current.data == null) {
                    return true; // Found a null element in the list.
                }
                current = current.next;
            }
        } else {
            // If the object is not null, look for an element equal to the object.
            while (current != null) {
                if (object.equals(current.data)) {
                    return true; // Found an element equal to the object.
                }
                current = current.next;
            }
        }
        return false; // Object not found in the list.
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size]; // Initialize an array of Object with the size of the linked list.
        int i = 0; // Start with the first index.
        ListNode<T> current = head; // Start traversal from the head of the list.

        // Traverse the list and fill the array.
        while (current != null) {
            result[i++] = current.data; // Assign the data from the current node to the array.
            current = current.next; // Move to the next node.
        }

        return result; // Return the filled array.
    }


    @Override
    public void clear() {
        // Iterate through the list and remove all references
        ListNode<T> current = head;
        while (current != null) {
            ListNode<T> next = current.next;
            current.data = null; // Help garbage collection by clearing the data reference
            current.next = null; // Clear reference to the next node
            current.prev = null; // Clear reference to the previous node
            current = next;      // Move to the next node
        }

        // Finally, reset head and tail to null to fully clear the list
        head = null;
        tail = null;
        size = 0; // Reset the size of the list
    }


    @Override
    public int size() {
        return size; // Return the size of the list which is updated on every add/remove operation.
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> current = head;  // Start with the first element in the list.

            @Override
            public boolean hasNext() {
                return current != null;  // Return true if there is another element next.
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();  // Throw an exception if there is no next element.
                }
                T data = current.data;  // Retrieve the data from the current node.
                current = current.next;  // Move to the next node.
                return data;  // Return the data.
            }
        };
    }

}