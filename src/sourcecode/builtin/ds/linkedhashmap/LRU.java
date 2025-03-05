package sourcecode.builtin.ds.linkedhashmap;

public interface LRU<K,V> {
    void insertKeyValuePair(K key,V value);
    V getValueFromKey(K key);
    K getMostRecentKey();
}
