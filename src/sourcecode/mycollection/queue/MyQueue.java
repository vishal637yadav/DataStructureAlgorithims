package sourcecode.mycollection.queue;

public class MyQueue<E> implements Queue<E>{

    private static class Node<E>{
        Node<E> prev ;
        E data;
        Node<E> next;

        Node(E data){
            this.data = data;
        }

        @Override
        public String toString() {
            String s = super.toString().replaceAll("sourcecode.mycollection.queue.MyQueue\\$","");
            return "("+s+"," + data +")";
        }
    }

    Node<E> head,tail;
    int size;

    @Override
    public void enQueue(E data) {
        Node<E> newNode = new Node<>(data);

        //if Queue isEmpty
        if(isEmpty()){
            tail = newNode;
            head = tail;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        this.size++;
    }

    @Override
    public E deQueue() {
        // edge-cases 1: when queue is empty() size = 0;
        if(isEmpty()) {
            return null;
        }

        Node<E> deletedNode = head;
        // edge-cases 2: when queue is size = 1
        if(!isEmpty() && size == 1){
            head = null;
            tail = null;
        // edge-cases 3: when queue is size > 2
        }else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return deletedNode.data;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        String nodeList = "";

        if(head != null) {
            Node<E> currNode = head;
            StringBuilder sb = new StringBuilder();
            while(currNode!=null){
                sb.append("    Prev-"+currNode.prev).append("|").append("Curr-"+currNode).append("|").append("Next-"+currNode.next);
                sb.append(",\n");
                currNode = currNode.next;
            }
            nodeList = sb.substring(0,sb.length()-2);
        }

        return "MyQueue\n{" +
                "\n head=" + head +
                ",\n tail=" + tail +
                ",\n size=" + size +
                ",\n NodeList = " +
                "\n  [\n"+nodeList+"\n  ]"+
                "\n}";
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println("---------enQueue : Operation--------------");
        System.out.println("calling1 enQueue :"+myQueue);
        myQueue.enQueue(1);
        System.out.println("calling2 enQueue:"+myQueue);
        myQueue.enQueue(2);
        System.out.println("calling3 enQueue:"+myQueue);
        myQueue.enQueue(3);
        System.out.println("calling4 enQueue:"+myQueue);
        myQueue.enQueue(4);
        System.out.println("calling5 enQueue:"+myQueue);

        //myQueue.enQueue(5);
        System.out.println("---------deQueue : Operation--------------");
        System.out.println(myQueue);
        System.out.println("calling1 deQueue :"+myQueue.deQueue());
        System.out.println("after dequeue:"+myQueue);
        System.out.println("calling2 deQueue :"+myQueue.deQueue());
        System.out.println("after dequeue:"+myQueue);
        System.out.println("myQueue.isEmpty():"+myQueue.isEmpty());
        System.out.println("calling3 deQueue :"+myQueue.deQueue());
        System.out.println("after dequeue:"+myQueue);
        System.out.println("myQueue.isEmpty():"+myQueue.isEmpty());
        System.out.println("calling4 deQueue :"+myQueue.deQueue());
        System.out.println("after dequeue:"+myQueue);
        System.out.println("myQueue.isEmpty():"+myQueue.isEmpty());
        System.out.println("calling5 deQueue :"+myQueue.deQueue());
        System.out.println("after dequeue:"+myQueue);
        System.out.println("myQueue.isEmpty():"+myQueue.isEmpty());

    }

}