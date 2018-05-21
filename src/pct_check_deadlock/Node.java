package pct_check_deadlock;

import java.util.LinkedList;

public class Node {
    String name;
    LinkedList<Node> nodes = new LinkedList<>();

    int mark;
    public final static  int markNotVisited = 0;
    public final static  int markWaiting = 1;
    public final static  int markVisited = 2;

    Node from;

    public Node(String name) {
        this.name = name;
    }

    public void addNode(Node node, boolean inverse) {
        this.nodes.add(node);
        if (inverse) {
//            node.nodes.add(this);  //因逻辑重复，写成下面形式
            node.addNode(this, false);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
