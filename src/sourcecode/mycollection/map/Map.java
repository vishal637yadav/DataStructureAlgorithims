package sourcecode.mycollection.map;

public interface Map<K,V> {

    V put(K key, V value);
    V get(K key);

}
