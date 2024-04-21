import java.util.Scanner;

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
    }
}