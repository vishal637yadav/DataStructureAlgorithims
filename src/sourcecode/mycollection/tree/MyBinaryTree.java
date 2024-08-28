package sourcecode.mycollection.tree;

import sourcecode.mycollection.queue.MyQueue;
import sourcecode.mycollection.stack.linklist.MyStack;

public class MyBinaryTree<E> implements Tree<E> {

    private static class Node<E> {
        Node<E> left;
        E data;
        Node<E> right;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            String s = super.toString().replaceAll("sourcecode.mycollection.tree.MyBinaryTree\\$", "");
            return "(" + s + "," + data + ")";
        }

    }

    Node<E> rootNode;

    @Override
    public void add(E data) {
        Node<E> newNode = new Node<>(data);

        if (rootNode == null) {
            rootNode = newNode;
        } else {
            MyQueue<Node<E>> queue = new MyQueue<>();
            queue.enQueue(rootNode);

            // Breadth First Traversal
            while (!queue.isEmpty()) {
                Node<E> currNode = queue.deQueue();
                visit(currNode);

                if (currNode.left != null) {
                    queue.enQueue(currNode.left);
                } else {
                    currNode.left = newNode;
                    break;
                }

                if (currNode.right != null) {
                    queue.enQueue(currNode.right);
                } else {
                    currNode.right = newNode;
                    break;
                }
            }
        }
    }

    @Override
    public void inOrderTraversal(){

        System.out.println("----------Recursive-Approach--inOrderTraversal---------------");
        inOrderTraversalRecursively(rootNode);
        System.out.println();
        System.out.println("----------Iterative-Approach--inOrderTraversal---------------");
        inOrderTraversalIteratively();
        System.out.println();
    }

    private void inOrderTraversalRecursively(Node<E> node) {
        //base Condition
        if(node == null) {
            return ;
        }
        inOrderTraversalRecursively(node.left);
        //visit(node);
        System.out.print(node.data+",");
        inOrderTraversalRecursively(node.right);
    }

    public void inOrderTraversalIteratively() {

        //Edge Case 1 : if tree is empty
        if (rootNode == null) {
            return ;
        }

        MyStack<Node<E>> stack = new MyStack<>();
        Node<E> currNode = rootNode;
        while((currNode != null) || (!stack.isEmpty())){

            while(currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            visit(currNode);
            System.out.print(currNode.data+",");
            currNode = currNode.right;
        }
    }

    private String visit(Node<E> node) {
        //System.out.println("Curr("+node+","+node.data+")");
        StringBuilder sb = new StringBuilder();
        return sb.append("    Left-" + node.left).append("|").append("Curr-" + node).append("|").append("Right-" + node.right).toString();
        //return node.data+"";
    }


    @Override
    public String toString() {
        String nodeList = "";

        if (rootNode != null) {

            StringBuilder sb = new StringBuilder();
            // Breadth First / Level Order Traversal
            MyQueue<Node<E>> queue = new MyQueue<>();
            queue.enQueue(this.rootNode);
            while (!queue.isEmpty()) {
                Node<E> currNode = queue.deQueue();
                sb.append(visit(currNode));
                sb.append(",\n");

                if (currNode.left != null) {
                    queue.enQueue(currNode.left);
                }

                if (currNode.right != null) {
                    queue.enQueue(currNode.right);
                }
            }
            nodeList = sb.substring(0, sb.length() - 2);
        }

        return "MyBinaryTree\n{" +
                "\n rootNode=" + rootNode +
                ",\n NodeList = " +
                "\n  [\n" + nodeList + "\n  ]" +
                "\n}";
    }

    @Override
    public void preOrderTraversal(){

        System.out.println("----------Recursive-Approach--Pre-Order-Traversal---------------");
        preOrderTraversalRecursively(rootNode);
        System.out.println();
        System.out.println("----------Iterative-Approach--Pre-Order-Traversal---------------");
        preOrderTraversalIteratively();
        System.out.println();
    }

    public void preOrderTraversalRecursively(Node<E> currNode){

        //base condition
        if(currNode == null){
            return;
        }

        System.out.print(currNode.data+",");
        preOrderTraversalRecursively(currNode.left);
        preOrderTraversalRecursively(currNode.right);

    }

    public void preOrderTraversalIteratively(){

        if(rootNode == null){
            return;
        }

        Node<E> currNode = rootNode;
        MyStack<Node<E>> stack = new MyStack<>();

        while(currNode!=null || !stack.isEmpty()){

            while(currNode!=null){
                System.out.print(currNode.data+",");
                stack.push(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            currNode = currNode.right;
        }

    }

    @Override
    public void postOrderTraversal(){

        System.out.println("----------Recursive-Approach--Post-Order-Traversal---------------");
        postOrderTraversalRecursively(rootNode);
        System.out.println();
        System.out.println("----------Iterative-Approach--Post-Order-Traversal--Using Two Stack-------------");
        postOrderTraversalIteratively();
        System.out.println();

        System.out.println("----------Iterative-Approach--Post-Order-Traversal--Using One Stack-------------");
        postOrderTraversalIterativelyUsingOneStack();
        System.out.println();

    }

    public void postOrderTraversalRecursively(Node<E> currNode)
    {
        //base condition
        if(currNode == null){
            return;
        }

        postOrderTraversalRecursively(currNode.left);
        postOrderTraversalRecursively(currNode.right);
        System.out.print(currNode.data+",");

    }

    // Using Two Stacks --->>----
    public void postOrderTraversalIteratively() {

        if(rootNode == null){
            return;
        }

        MyStack<Node<E>> stack1 = new MyStack<>();
        MyStack<Node<E>> stack2 = new MyStack<>();
        Node<E> currNode = rootNode ;

        stack1.push(currNode);
        while(!stack1.isEmpty()){
            currNode = stack1.pop();
            stack2.push(currNode);

            if(currNode.left!= null){
                stack1.push(currNode.left);
            }

            if(currNode.right!= null){
                stack1.push(currNode.right);
            }
        }

        // Printing Post-Order Traversal
        while (!stack2.isEmpty()){
            currNode = stack2.pop();
            System.out.print(currNode.data+",");
        }

    }

    public void postOrderTraversalIterativelyUsingOneStack() {
        //working on it....
        if(rootNode == null){
            return;
        }

        MyStack<Node<E>> stack1 = new MyStack<>();
        Node<E> currNode = rootNode ;

        stack1.push(currNode);
        Node<E> prevNode = null;

        while(!stack1.isEmpty()){
            currNode = stack1.peek();

            if(prevNode == null || prevNode.left == currNode || prevNode.right == currNode){
                if(currNode.left != null){
                    stack1.push(currNode.left);
                }else if(currNode.right != null){
                    stack1.push(currNode.right);
                }else{
                    System.out.print(currNode.data+",");
                }
            }else if(currNode.left == prevNode){

                if(currNode.right != null){
                    stack1.push(currNode.right);
                }else{
                    currNode = stack1.pop();
                    System.out.print(currNode.data+",");
                }

            }else if( currNode.right == prevNode){
                currNode = stack1.pop();
                System.out.print(currNode.data+",");
            }
            prevNode = currNode;
        }

    }

    public static void main(String[] args) {
        System.out.println("----------------My Tree Demo-----------------");
        MyBinaryTree<Integer> myTree = new MyBinaryTree<>();
        System.out.println("myTree0  :" + myTree);
        myTree.add(1);
        System.out.println("myTree1  :" + myTree);
        myTree.add(2);
        System.out.println("myTree2  :" + myTree);
        myTree.add(3);
        System.out.println("myTree3  :" + myTree);
        myTree.add(4);
        System.out.println("myTree4  :" + myTree);
        myTree.add(5);
        System.out.println("myTree5  :" + myTree);
        myTree.add(6);
        System.out.println("myTree6  :" + myTree);
        myTree.add(7);
        System.out.println("myTree7  :" + myTree);

        System.out.println("----------------MyBinaryTree.inOrderTraversal-----------------");
        myTree.inOrderTraversal();
        myTree.preOrderTraversal();
        myTree.postOrderTraversal();

    }
}
