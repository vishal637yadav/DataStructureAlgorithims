package sourcecode.builtin.ds.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> al = new LinkedList<>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");

        traversalUsingIterator(al);
        traversalUsingForEachLoop(al);
        traversalUsingStreamsForEach(al);
        addElementAtLast(al, "Vishal");
        addElementAtLast(al,"Ramesh");
        traversalUsingForEachLoop(al);

    }

    public static <T> void addElementAtLast(LinkedList<T> linkedList, T data) {
        linkedList.add(data);
    }

    public static <T> void traversalUsingIterator(LinkedList<T> linkedList) {
        System.out.println("-------------------------start :traversalUsingIterator-------------------------");
        Iterator<T> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------------end :traversalUsingIterator-------------------------");
    }

    public static <T> void traversalUsingForEachLoop(LinkedList<T> linkedList) {
        System.out.println("-------------------------start :traversalUsingIterator-------------------------");
        for (T s : linkedList) {
            System.out.println(s);
        }
        System.out.println("---------------------------end :traversalUsingIterator-------------------------");
    }

    public static <T> void traversalUsingStreamsForEach(LinkedList<T> linkedList) {
        System.out.println("-------------------------start :traversalUsingStreamsForEach-------------------------");
        linkedList.forEach(System.out::println);
        System.out.println("---------------------------end :traversalUsingStreamsForEach-------------------------");
    }


}