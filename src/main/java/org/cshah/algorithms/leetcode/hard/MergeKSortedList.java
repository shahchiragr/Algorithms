package org.cshah.algorithms.leetcode.hard;

import org.cshah.algorithms.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {
    static class Item {
        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
        int value;
        int index;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length ==0  )
            return null;

        if (lists.length == 1)
            return lists[0];

        PriorityQueue<Item> heap = new PriorityQueue<Item>(new Comparator<Item>() {
            public int compare(Item o1, Item o2) {
                if (o1.value < o2.value)
                    return -1;

                if (o1.value > o2.value)
                    return  1;

                return 0;
            }
        });

        for (int index=0; index < lists.length; index++) {
            if (lists[index] != null) {
                heap.offer(new Item(lists[index].val, index));
                lists[index] = lists[index].next;
            }
        }

        ListNode node = null;
        ListNode head = null;

        while (!heap.isEmpty()) {
            Item item =heap.poll();
            if (lists[item.index] != null) {
                heap.offer(new Item(lists[item.index].val, item.index));
                lists[item.index] = lists[item.index].next;
            }
            if (node == null) {
                node = new ListNode(item.value);
                head = node;
            } else {
                node.next = new ListNode(item.value);
                node = node.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;


        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode results = mergeKSortedList.mergeKLists(lists);

        System.out.println();
    }
}
