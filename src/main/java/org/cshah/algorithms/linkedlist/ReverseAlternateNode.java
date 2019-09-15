package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 11/25/14.
 */
public class ReverseAlternateNode {

    public ListNode generateNode() {
        //    ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, null)))))));
            ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        return  node;
    }

    public void reverse(ListNode head) {
  //      printNode(node);
        ListNode previousPointer =null, nextPointer1 =null,nextPointer2  = null;
        nextPointer1 = head;
        nextPointer2 = head.next;

        ListNode newHead =null;

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

    public ListNode reverse_Algo2(ListNode head) {
   //     printNode(head);

        if (head == null || head.next == null)
            return head;

        ListNode newHead =null;

        //if only two nodes are there in the list
        // e.g. 1 -> 2
        if (head.next.next == null) {
            newHead = head.next;
            head.next.next = head;
            head.next = null;
            return  newHead;
        }


        ListNode nextPointer1 =null,nextPointer3  = null;
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

    public static void printNode(ListNode root) {
        ListNode printNOde = root;
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
