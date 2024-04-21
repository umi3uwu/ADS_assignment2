public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    public boolean empty() {
        return queue.size() == 0;
    }

    public int size() {
        return queue.size();
    }

    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.getFirst();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T frontElement = queue.getFirst();
        queue.removeFirst();
        return frontElement;
    }
}
