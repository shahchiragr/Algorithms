package org.cshah.algorithms.ik.tree;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

    static class Node {

        public Node(String dir) {
            this.dir = dir;
        }
        String dir;
        List<Node>  dirList = new ArrayList<Node>();

        public void addNode(Node node) {
            dirList.add(node);
        }

    }

    public void printSubDirRec(Node root,String path, List<String> paths) {
        paths.add(path);

        List<Node> dirList = root.dirList;
        for (int i=0; i < dirList.size(); i++) {
            Node child = dirList.get(i);
            printSubDirRec(child, path + "/" + child.dir, paths );
        }
    }
    public static Node getData() {
        Node root = new Node("/");
        Node n1 = new Node("users");
        Node n2 = new Node("systems");
        root.addNode(n1);
        root.addNode(n2);

        Node n3 = new Node("bob");
        Node n4 = new Node("alice");

        n1.addNode(n3);
        n1.addNode(n4);

        Node n5 = new Node("pictures");
        n4.addNode(n5);

        return root;
    }
    public static void main(String[] args) {
        PrintAllPaths printAllPaths = new PrintAllPaths();
        List<String> paths = new ArrayList<String>();
        printAllPaths.printSubDirRec(PrintAllPaths.getData(), "", paths);

        for (String path : paths) {
            System.out.println(path);
        }
    }

}
