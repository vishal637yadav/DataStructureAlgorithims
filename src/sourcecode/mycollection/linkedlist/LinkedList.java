package sourcecode.mycollection.linkedlist;

public interface LinkedList<E> {

    void add(E data);

    void addFirst(E data);

    E set(int index, E data) throws Exception;

    E removeByData(E data);

    E removeElementAtIndex(int index);

    boolean isEmpty();
}
