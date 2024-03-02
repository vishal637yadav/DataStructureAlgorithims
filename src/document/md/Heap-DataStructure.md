# Heap Data Structure

## Types of Heap:
1. Min-Heap
2. Max-Heap:

## Java Built-in Data Structure in Collocation Framework for Heap Data Structure.
### PriorityQueues
* We can use Java **PriorityQueue** as a Heap.
* **Min Heap:** To keep the **min element** always **on top**, so you can access it in **O(1)**.

      PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
* **Max Heap:**  To keep the **max element** always **on top**, so you can access it in **O(1)**.

      PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

### Time-Complexity of Heap Operation in Heap :
* **add    -->** To **add** element to the queue. **O(log n)**
* **remove -->** To **get** and remove the min/max. **O(log n)**
* **peek   -->** To **get**, but not remove the min/max. **O(1)**
---

### PriorityQueue Example

    package sourcecode.builtin.ds.heap;
    
    import java.util.Collections;
    import java.util.PriorityQueue;
    
    public class PriorityQueueDemo {
    
        public static void main(String[] args) {
    
            System.out.println("------------------!! PriorityQueueDemo !!------------------");
            System.out.println("------------:--:Creating Max Heap:--:--Default----");
    
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
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


### Output :--
    "C:\Program Files\Java\jdk-21\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.2\lib\idea_rt.jar=56298:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.3.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath F:\Programming\Code\21Feb\DataStructureAlgorithims\out\production\DataStructureAlgorithims sourcecode.builtin.ds.heap.PriorityQueueDemo
    ------------------!! PriorityQueueDemo !!------------------
    ------------:--:Creating Max Heap:--:--Default----
    minHeap.add(40)  :: true
    minHeap.peek()   :: 40, minHeap          :: [40]
    minHeap.add(50)  :: true
    minHeap.peek()   :: 40, minHeap          :: [40, 50]
    minHeap.add(60)  :: true
    minHeap.peek()   :: 40, minHeap          :: [40, 50, 60]
    minHeap.add(10)  :: true
    minHeap.peek()   :: 10, minHeap          :: [10, 40, 60, 50]
    minHeap.remove() :: 10
    minHeap.peek()   :: 40, minHeap          :: [40, 50, 60]
    minHeap.add(5)   :: true
    minHeap.peek()   :: 5, minHeap          :: [5, 40, 60, 50]
    minHeap.add(15)  :: true
    minHeap.peek()   :: 5, minHeap          :: [5, 15, 60, 50, 40]
    ------------:--:Creating Max Heap:--:------------
    maxHeap.add(40)  :: true
    maxHeap.peek()   :: 40, maxHeap          :: [40]
    maxHeap.add(50)  :: true
    maxHeap.peek()   :: 50, maxHeap          :: [50, 40]
    maxHeap.add(60)  :: true
    maxHeap.peek()   :: 60, maxHeap          :: [60, 40, 50]
    maxHeap.add(10)  :: true
    maxHeap.peek()   :: 60, maxHeap          :: [60, 40, 50, 10]
    maxHeap.remove() :: 60
    maxHeap.peek()   :: 50, maxHeap          :: [50, 40, 10]
    maxHeap.add(5)   :: true
    maxHeap.peek()   :: 50, maxHeap          :: [50, 40, 10, 5]
    maxHeap.add(15)  :: true
    maxHeap.peek()   :: 50, maxHeap          :: [50, 40, 10, 5, 15]
    
    Process finished with exit code 0
