package sourcecode.mycollection.map;

public class MyHashMap<K, V> implements Map<K, V> {

    private static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            String s = super.toString().replaceAll("sourcecode.mycollection.map.MyHashMap\\$", "");
            return "(" + s + "," + hash + "," + getKey() + "," + getValue() + ",(Next-" + (next != null ? "[" + next.getKey() + "," + next.getValue() + "]" : next) + ")";
        }

        public final int hashCode() {
            return key.hashCode();
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            if (o instanceof Node<?, ?> node) {
                return this.getKey().equals(node.getKey()) && this.getValue().equals(node.getValue());
            } else {
                return false;
            }
        }


    }

    static final int DEFAULT_INITIAL_CAPACITY = 5;
    Node<K, V>[] table;
    int size;

    public MyHashMap() {
        table = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
    }


    @Override
    public V put(K key, V value) {

        V prevValue = null;

        int hashCode = key.hashCode();

        Node<K, V> newNode = new Node<>(hashCode, key, value, null);

        int bucketIndex = hashCode % DEFAULT_INITIAL_CAPACITY;

        if (table[bucketIndex] == null) {
            table[bucketIndex] = newNode;
            size++;
        } else {
            Node<K, V> prevNode = null;
            Node<K, V> currNode = table[bucketIndex];
            while (currNode != null) {

                if (currNode.getKey().equals(key)) {
                    prevValue = currNode.value;
                    currNode.value = value;
                    break;
                }
                prevNode = currNode;
                currNode = currNode.next;
            }

            if (prevValue == null) {
                prevNode.next = newNode;
                size++;
            }
        }
        return prevValue;
    }

    @Override
    public V get(K key) {

        int hashCode = key.hashCode();
        int bucketIndex = hashCode % DEFAULT_INITIAL_CAPACITY;

        if (table[bucketIndex] == null) {
            return null;
        } else {
            Node<K, V> currNode = table[bucketIndex];
            while (currNode != null) {
                if (currNode.getKey().equals(key)) {
                    return currNode.getValue();
                }
                currNode = currNode.next;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("MyHashMap\n[\n");
        sb.append("  DEFAULT_INITIAL_CAPACITY=").append(DEFAULT_INITIAL_CAPACITY).append(",").append("\n");
        sb.append("  size=").append(size).append(",").append("\n");
        sb.append("  table=").append("\n  {\n");

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) {
                sb.append("    [" + i + "]=").append(table[i]).append("\n");
            } else {
                sb.append("    [" + i + "]=");
                Node<K, V> currNode = table[i];
                while (currNode != null) {
                    sb.append(currNode).append("|");
                    currNode = currNode.next;
                }
                sb.append("\n");
            }
        }
        sb.append("  }").append("\n");
        sb.append("]").append("\n");

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println("------------------MyHashMap---------------------");
        MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
        myHashMap.put(1,"One");
        System.out.println(myHashMap);
        myHashMap.put(2,"Two");
        System.out.println(myHashMap);
        myHashMap.put(3,"Three");
        System.out.println(myHashMap);
        myHashMap.put(4,"Four");
        System.out.println(myHashMap);
        myHashMap.put(11,"Eleven");
        System.out.println(myHashMap);
        myHashMap.put(14,"Fourteen");
        System.out.println(myHashMap);

        System.out.println("myHashMap.get(11) :::"+myHashMap.get(11));
        System.out.println("myHashMap.put(1,\"1--to--1\"):::"+myHashMap.put(1,"1--to--1"));
        System.out.println("myHashMap.get(21) :::"+myHashMap.get(21));
        System.out.println("myHashMap.put(21,\"Twenty-One\") :::"+myHashMap.put(21,"Twenty-One"));

        System.out.println(myHashMap);

    }

}