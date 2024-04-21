public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.sort();
        System.out.println(list.indexOf(3)+ " "+ list.size());
        System.out.println(list.get(0));
        list.clear();

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(52);
        linkedList.add(2);
        linkedList.add(23);
        linkedList.add(44);
        linkedList.removeLast();
        linkedList.sort();
        Object[] int_arr = linkedList.toArray();
        for (int i = 0; i < int_arr.length; i++) {
            System.out.println(int_arr[i]);
        }

        MyMinHeap<Integer> heapExample = new MyMinHeap<>();
        heapExample.insert(3);
        heapExample.insert(4);
        heapExample.insert(5);
        heapExample.insert(6);
        heapExample.insert(123);
        heapExample.insert(1);
        while (!heapExample.empty()) {
            System.out.print(heapExample.extractMin() + " ");
        }
        System.out.println();

        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.peek());
        while (!queue.empty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
    }
}