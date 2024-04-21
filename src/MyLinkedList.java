import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private MyNode<T> head;
    private MyNode<T> tail;
    private int length;
    T item;

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);

        if(head == null){
            head=tail=newNode;
        }
        else {
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;

        }
        length++;
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("out of range");
        }
        MyNode<T> cur=head;
        for (int i = 0; i < index; i++) {
            cur=cur.next;
        }
        cur.data=item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("out of range");
        }
        MyNode<T> newNode = new MyNode<>(item);
        if(index == 0){
            addFirst(item);
            return;
        }
        if(index == length){
            add(item);
            return;
        }
        else{
            MyNode<T> cur=head;
            for (int i = 0; i < index; i++) {
                cur=cur.next;
            }
            newNode.next=cur.next;
            newNode.prev=cur;
            cur.next=newNode;
            length++;
        }
    }

    @Override
    public void addFirst(T item) {
        add(0,item);
    }

    @Override
    public void addLast(T item) {
        add(length,item);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("out of range");
        }
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current=current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        if (head==null)
            throw new NoSuchElementException("Empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if(tail==null)
            throw new NoSuchElementException("Empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("out of range");
        }
        if (index==0){
            removeFirst();
            return;
        }
        if(index==length-1){
            removeLast();
            return;
        }
        MyNode<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        length--;
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            length--;
        }
    }

    @Override
    public void removeLast() {
        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
        length--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            MyNode<T> current = head;
            for (int j = 0; j < length - 1 - i; j++) {
                if (current.data.compareTo(current.next.data) > 0) {
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object object){
        MyNode<T> current = tail;
        int index = length - 1;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private MyNode<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }

    private class MyNode<T>{
        T data;
        MyNode<T> next;
        MyNode<T> prev;
        MyNode(T data) {
            this.data=data;
        }
    }
}
