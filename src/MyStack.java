public class MyStack<T extends Comparable<T>> {
    private MyLinkedList<T> stack;

    public MyStack() {
        stack = new MyLinkedList<>();
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    public int size() {
        return stack.size();
    }

    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.getFirst();
    }

    public void push(T item) {
        stack.addFirst(item);
    }

    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T topElement = stack.getFirst();
        stack.removeFirst();
        return topElement;
    }
}
