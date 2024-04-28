
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
        ListNode<T> current = getNodeAtIndex(index);
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
            ListNode<T> current = getNodeAtIndex(index);
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
        ListNode<T> current = getNodeAtIndex(index);
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
        ListNode<T> current = getNodeAtIndex(index);
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

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        ListNode<T> current = head;
        while (current != null) {
            result[i++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        ListNode<T> current = head;
        while (current != null) {
            ListNode<T> next = current.next;
            current.data = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();

