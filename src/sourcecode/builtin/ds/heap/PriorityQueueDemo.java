package sourcecode.builtin.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        System.out.println("------------------!! PriorityQueueDemo !!------------------");
        System.out.println("------------:--:Creating Max Heap:--:--Default----");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(40)  :: " + minHeap.add(40));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(50)  :: " + minHeap.add(50));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(60)  :: " + minHeap.add(60));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(10)  :: " + minHeap.add(10));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.remove() :: " + minHeap.remove());
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(5)   :: " + minHeap.add(5));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);
        System.out.println("minHeap.add(15)  :: " + minHeap.add(15));
        System.out.println("minHeap.peek()   :: " + minHeap.peek() + ", minHeap          :: " + minHeap);

        System.out.println("------------:--:Creating Max Heap:--:------------");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(40)  :: " + maxHeap.add(40));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(50)  :: " + maxHeap.add(50));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(60)  :: " + maxHeap.add(60));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(10)  :: " + maxHeap.add(10));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.remove() :: " + maxHeap.remove());
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(5)   :: " + maxHeap.add(5));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);
        System.out.println("maxHeap.add(15)  :: " + maxHeap.add(15));
        System.out.println("maxHeap.peek()   :: " + maxHeap.peek() + ", maxHeap          :: " + maxHeap);

    }

}
