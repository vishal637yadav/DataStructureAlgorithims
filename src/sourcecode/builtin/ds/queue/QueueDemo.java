package sourcecode.builtin.ds.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        System.out.println("-------Queue Demo----------");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("----queue :"+ queue);
        int peekElement = queue.peek();
        System.out.println("peekElement:"+peekElement);

        

    }
}
