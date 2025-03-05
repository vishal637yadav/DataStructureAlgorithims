package sourcecode.builtin.ds.linkedhashmap;

import java.util.HashMap;

public class LRUCache<K, V> implements LRU<K, V> {

    // Doubly Linked-List Inner-Class
    private static class DoublyLinkedList<K, V> {

        //Node Inner-Class
        private static class DoublyLinkedNode<K,V>
        {
            K key;
            V value;
            DoublyLinkedNode<K,V> prev;
            DoublyLinkedNode<K,V> next;

            public DoublyLinkedNode(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            @Override
            public String toString() {
                String s = super.toString().replaceAll("sourcecode.builtin.ds.linkedhashmap.LRUCache.DoublyLinkedList\\$", "");
                return "( " + s + " {key=" + getKey() + ", value="+getValue()+"} )";
            }
        }

        DoublyLinkedNode<K,V> head;
        DoublyLinkedNode<K,V> tail;

        public DoublyLinkedNode<K,V> addFront(K key,V value) {
            DoublyLinkedNode<K,V> newNode = new DoublyLinkedNode<>(key,value);

            if(head == null) {
                head = newNode;
                tail = newNode;
            }else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return newNode;
        }

        public DoublyLinkedNode<K,V> removeTail() {
            DoublyLinkedNode<K,V> prevTail = tail;
            tail=tail.prev;
            tail.next=null;
            return prevTail;
        }

        public DoublyLinkedNode<K,V> removeNthNode(DoublyLinkedNode<K,V> node) {
            // getting Prev Node and Next Node
            DoublyLinkedNode<K,V> prevNode = node.prev;
            DoublyLinkedNode<K,V> nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;

            node.prev = null;
            node.next = null;
            return node;
        }

        @Override
        public String toString() {

            String nodeList = "";

            if(head != null) {
                DoublyLinkedNode<K,V> currNode = head;
                StringBuilder sb = new StringBuilder();
                while(currNode!=null){
                    sb.append("   ").append("Curr-").append(currNode).append("|").append("Next-").append(currNode.next).append("|").append("Prev-").append(currNode.prev);
                    sb.append(",\n");
                    currNode = currNode.next;
                }
                nodeList = sb.substring(0,sb.length()-2);
            }

            return "DoublyLinkedList\n{" +
                    "\n head=" + head +
                    ",\n tail=" + tail +
                    ",\n NodeList = " +
                    "\n  [\n"+nodeList+"\n  ]"+
                    "\n}";
        }
    }

    HashMap<K,DoublyLinkedList.DoublyLinkedNode<K,V>> nodeMap ;
    DoublyLinkedList<K,V> doublyLinkedList;
    int cacheSize;
    int size;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.nodeMap = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Override
    public void insertKeyValuePair(K key, V value) {
        DoublyLinkedList.DoublyLinkedNode<K,V> newlyAddedNode = doublyLinkedList.addFront(key,value);
        if(size < cacheSize) {
            nodeMap.put(key, newlyAddedNode);
            size++;
        }else {
            DoublyLinkedList.DoublyLinkedNode<K,V> prevTailNode = doublyLinkedList.removeTail();
            nodeMap.remove(prevTailNode.key);
        }
    }

    @Override
    public V getValueFromKey(K key) {
        if(nodeMap.containsKey(key)) {
            DoublyLinkedList.DoublyLinkedNode<K,V> nthNode = doublyLinkedList.removeNthNode(nodeMap.get(key));
            doublyLinkedList.addFront(nthNode.key,nthNode.value);
            return nthNode.value;
        }
        return null;
    }

    @Override
    public K getMostRecentKey() {
        return doublyLinkedList.head.getKey();
    }

    @Override
    public String toString() {
        return "LRUCache\n{\n" +
                " nodeMap=" + nodeMap +
                ",\n doublyLinkedList=" + doublyLinkedList +
                ",\n cacheSize=" + cacheSize +
                ",\n size=" + size +
                "\n}";
    }
}

