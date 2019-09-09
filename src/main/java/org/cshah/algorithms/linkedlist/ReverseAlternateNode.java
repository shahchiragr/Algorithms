package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class ReverseAlternateNode {

    public Node generateNode() {
        //    Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, null)))))));
            Node node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
        return  node;
    }

    public void reverse(Node head) {
  //      printNode(node);
        Node previousPointer =null, nextPointer1 =null,nextPointer2  = null;
        nextPointer1 = head;
        nextPointer2 = head.next;

        Node newHead =null;

        while (nextPointer1 != null && nextPointer2 != null) {
            if (previousPointer != null)
                previousPointer.next = nextPointer2;

            nextPointer1.next = nextPointer2.next;
            nextPointer2.next = nextPointer1;


            if (newHead ==null) {
                newHead = nextPointer2;
            }

            previousPointer = nextPointer1;
            if (nextPointer1 != null) {
                nextPointer1 = nextPointer1.next;
            }
            if (nextPointer1 != null) {
                nextPointer2 = nextPointer1.next;
            }
        }

   //     printNode(newHead);
    }

    public Node reverse_Algo2(Node head) {
   //     printNode(head);

        if (head == null || head.next == null)
            return head;

        Node newHead =null;

        //if only two nodes are there in the list
        // e.g. 1 -> 2
        if (head.next.next == null) {
            newHead = head.next;
            head.next.next = head;
            head.next = null;
            return  newHead;
        }


        Node nextPointer1 =null,nextPointer3  = null;
        nextPointer1 = head;
        nextPointer3 = head.next.next;


        while (nextPointer1 != null && nextPointer3 != null) {
            if (newHead == null)
                newHead = nextPointer1.next;

            nextPointer1.next.next = nextPointer1;


            if (nextPointer3.next !=null)
                nextPointer1.next = nextPointer3.next;
            else
                nextPointer1.next = nextPointer3;

            nextPointer1 = nextPointer3;

            if (nextPointer3.next != null)
                nextPointer3 = nextPointer3.next.next;
            else
                nextPointer3 = null;
        }

 //       printNode(newHead);
        return newHead;
    }

    public static void printNode(Node root) {
        Node printNOde = root;
        while (printNOde != null) {
            System.out.print(printNOde.val + " -> ");
            printNOde = printNOde.next;
        }
        System.out.println("NULL");
    }
    public static void main(String args[]) {

        ReverseAlternateNode reverseAlternateNode  = new ReverseAlternateNode();
        reverseAlternateNode.reverse(reverseAlternateNode.generateNode());
        reverseAlternateNode.reverse_Algo2(reverseAlternateNode.generateNode());

        int ii = (int)-91283472332L;
        System.out.println(ii + " : " + Integer.MIN_VALUE);
    }

}
