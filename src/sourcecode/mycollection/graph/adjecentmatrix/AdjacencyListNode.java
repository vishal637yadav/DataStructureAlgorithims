package sourcecode.mycollection.graph.adjecentmatrix;

import java.util.ArrayList;

public class AdjacencyListNode {

    public static class Node {
        char name;
        int index;
        ArrayList<Node> children;

        public Node(char name,int index) {
            this.name = name;
            this.index= index;
            children = new ArrayList<>();
        }

        @Override
        public String toString() {

            StringBuilder sbChildrenNodeList = new StringBuilder();
            sbChildrenNodeList.append("[");
            for(int i=0;i<children.size();i++){
                if(i==children.size()-1){
                    sbChildrenNodeList.append(children.get(i).name).append("(").append(children.get(i).index).append(")");
                }else{
                    sbChildrenNodeList.append(children.get(i).name).append("(").append(children.get(i).index).append(")").append(",");
                }
            }
            sbChildrenNodeList.append("]");
            String s = super.toString().replaceAll("sourcecode.mycollection.graph.adjecentmatrix.AdjacencyListNode\\$", "");

            return "{" + s + ", name=" + name + ", index=" + index +
                    ",\n\t\t\t\t\t\tchildren=" + sbChildrenNodeList + "}";
        }

    }

    Node [] sourceNodesArray;
    int numberOfNodes;

    public AdjacencyListNode(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.sourceNodesArray = new Node[numberOfNodes];
        for(int i=0;i<numberOfNodes;i++){
            this.sourceNodesArray[i] = new Node((char)(65+i),i);
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Node node : sourceNodesArray) {
            sb.append("\n\t\tSourceNode-").append(node).append("\n");
        }
        return "AdjacencyListNode{\n" +
                "\tgraph=\n\t[" + sb +
                "\t],\n\tnumberOfNodes=" + numberOfNodes +
                "\n}\n";
    }

    public void addAdjacentNodes(Node sourceNode, Node neighbouringNode){
        sourceNodesArray[sourceNode.index].children.add(neighbouringNode);
    }

    public void initialiseGraph(){
        AdjacencyListNode graph = new AdjacencyListNode(7);
        addAdjacentNodes(graph.sourceNodesArray[0], graph.sourceNodesArray[1]);
        addAdjacentNodes(graph.sourceNodesArray[0], graph.sourceNodesArray[3]);
        addAdjacentNodes(graph.sourceNodesArray[1], graph.sourceNodesArray[0]);
        addAdjacentNodes(graph.sourceNodesArray[1], graph.sourceNodesArray[2]);
        addAdjacentNodes(graph.sourceNodesArray[2], graph.sourceNodesArray[3]);
        addAdjacentNodes(graph.sourceNodesArray[2], graph.sourceNodesArray[1]);
        addAdjacentNodes(graph.sourceNodesArray[3], graph.sourceNodesArray[0]);
        addAdjacentNodes(graph.sourceNodesArray[3], graph.sourceNodesArray[2]);
        addAdjacentNodes(graph.sourceNodesArray[3], graph.sourceNodesArray[4]);
        addAdjacentNodes(graph.sourceNodesArray[4], graph.sourceNodesArray[3]);
        addAdjacentNodes(graph.sourceNodesArray[4], graph.sourceNodesArray[5]);
        addAdjacentNodes(graph.sourceNodesArray[4], graph.sourceNodesArray[6]);
        addAdjacentNodes(graph.sourceNodesArray[5], graph.sourceNodesArray[6]);
        addAdjacentNodes(graph.sourceNodesArray[5], graph.sourceNodesArray[4]);
        addAdjacentNodes(graph.sourceNodesArray[6], graph.sourceNodesArray[5]);
        addAdjacentNodes(graph.sourceNodesArray[6], graph.sourceNodesArray[4]);

    }

    public static void main(String[] args) {

        System.out.println("------------------------------------");
        AdjacencyListNode graph = new AdjacencyListNode(7);
        graph.initialiseGraph();
        System.out.println(graph);

    }
}
