import java.util.Iterator;
import java.util.Comparator;
public class MyArrayList<T extends Comparable<T>> implements MyList<T>{
    private Object[] list;
    private int size;
    private int lenght;
    public static final int DEFAULT_CAPACITY=5;
    public MyArrayList() {
        list = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
        lenght=0;
    }

    private void increaseCapacity() {
        Object[] newList = new Object[list.length*2];
        for (int i = 0; i < list.length; i++) {
            newList[i]=list[i];
        }
        list = newList;
    }
    @Override
    public void add(T item) {
        if (lenght==size)
            increaseCapacity();
        list[lenght++]=item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        list[index]=item;
    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        if (lenght==size)
            increaseCapacity();
        for (int i = lenght - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = item;
        lenght++;

    }

    @Override
    public void addFirst(T item) {
        add(0,item);
    }

    @Override
    public void addLast(T item) {
        add(lenght,item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) list[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(lenght-1);
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        lenght--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(lenght-1);
    }

    @Override
    public void sort() {
        for (int i = 0; i < lenght - 1; i++) {
            for (int j = 0 ; j < lenght - i - 1; j++) {
                if (get(j).compareTo(get(j + 1)) > 0) {
                    Object temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < lenght; i++) {
            if (list[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = lenght - 1; i >= 0; i--) {
            if (list[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = list[i];
        }
        return array;
    }

    @Override
    public void clear() {
        list = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
        lenght = 0;
    }

    @Override
    public int size() {
        return lenght;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < lenght;
            }

            @Override
            public T next() {
                return get(currentIndex++);
            }
        };
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= lenght) {
            throw new IndexOutOfBoundsException("index out of range");
        }
    }
}
