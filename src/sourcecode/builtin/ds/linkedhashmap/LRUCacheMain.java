package sourcecode.builtin.ds.linkedhashmap;


public class LRUCacheMain {

    public static void main(String[] args) {
        System.out.println("-----LRU-Cache-Testing-----");

        LRUCache<Integer,String> cache = new LRUCache<>(5);
        cache.insertKeyValuePair(1,"A");
        System.out.println("--1----"+cache);
        cache.insertKeyValuePair(2,"B");
        System.out.println("--2----"+cache);
        cache.insertKeyValuePair(3,"C");
        System.out.println("--3----"+cache);
        cache.insertKeyValuePair(4,"D");
        System.out.println("--4----"+cache);

        cache.getValueFromKey(2);
        System.out.println("--2-getValueFromKey---"+cache);
        cache.insertKeyValuePair(5,"E");
        System.out.println("--5----"+cache);
        cache.insertKeyValuePair(6,"f");
        System.out.println("--6----"+cache);
        cache.insertKeyValuePair(7,"g");
        System.out.println("--7----"+cache);
        cache.insertKeyValuePair(8,"h");
        System.out.println("--8----"+cache);

    }
}

