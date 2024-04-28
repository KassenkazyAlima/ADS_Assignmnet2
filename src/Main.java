public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
        testQueue();
        testMinHeap();
    }

    private static void testArrayList() {
        System.out.println("Testing MyArrayList:");

        MyArrayList<Integer> arrayList = new MyArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);

        System.out.println("Element at index 1: " + arrayList.get(1));

        arrayList.set(1, 50);
        System.out.println("Element at index 1 after set: " + arrayList.get(1));

        System.out.println("Size of array list: " + arrayList.size());
    }

    private static void testLinkedList() {
        System.out.println("\nTesting MyLinkedList:");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        System.out.println("Element at index 1: " + linkedList.get(1));

        System.out.println("Size of linked list: " + linkedList.size());
    }

    private static void testStack() {
        System.out.println("\nTesting MyStack:");

        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Peeked element: " + stack.peek());
        System.out.println("Size of stack: " + stack.size());
    }

    private static void testQueue() {
        System.out.println("\nTesting MyQueue:");

        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Peeked element: " + queue.peek());
        System.out.println("Size of queue: " + queue.size());
    }

    private static void testMinHeap() {
        System.out.println("\nTesting MyMinHeap:");

        MyMinHeap<Integer> minHeap = new MyMinHeap<>();

        minHeap.add(20);
        minHeap.add(10);
        minHeap.add(30);

        System.out.println("Extracted min element: " + minHeap.extractMin());
        System.out.println("Peeked min element: " + minHeap.peek());
        System.out.println("Size of min heap: " + minHeap.size());
    }
}
