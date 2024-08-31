package sourcecode.mycollection.heap;

public interface Heap<E> {

    void insert(E data);
    E delete();

    void preOrderTraversal();
    void inOrderTraversal();
    void postOrderTraversal();

}
