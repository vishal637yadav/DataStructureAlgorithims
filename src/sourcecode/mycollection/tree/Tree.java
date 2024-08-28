package sourcecode.mycollection.tree;

public interface Tree<E> {

    void add(E data);
    void inOrderTraversal();
    void preOrderTraversal();
    void postOrderTraversal();

}
