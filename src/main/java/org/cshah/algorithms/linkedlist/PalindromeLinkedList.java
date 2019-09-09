package org.cshah.algorithms.linkedlist;

/**
 * Created by chirag on 10/12/16.
 */
public class PalindromeLinkedList {

    class Result {

        public Result(Node node, boolean result) {
            this.node = node;
            this.result = result;
        }

        Node node;
        boolean result;
    }

    Result isPalindromeRecursive(Node head, int length) {
        if (head == null || length ==0) {
            return new Result(null, true);
        } else if (length == 1)  {
            return  new Result(head.next, true);
        } else if (length == 2) {
            return  new Result(head.next.next, head.val == head.next.val);
        }

        Result res=  isPalindromeRecursive(head.next, length -2);

        if (!res.result || res.node == null) {
            return  res;
        }  else {
            res.result = head.val == res.node.val;
            res.node = res.node.next;
            return  res;
        }
    }

    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = new Node(4);
        n.next.next.next.next = new Node(3);
        n.next.next.next.next.next = new Node(2);
        n.next.next.next.next.next.next = new Node(1);

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        Result result = palindromeLinkedList.isPalindromeRecursive(n, 7);
        System.out.println("Is Palindrome " + result.result);
    }
}
