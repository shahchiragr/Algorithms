package org.cshah.algorithms.misc;

import java.util.HashMap;

public class LRUCache {
    // define a double LinkedList Node, with key, value, pointer to next node and previous node
    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // using hashmap to get the Node in O(1) and define dummy head and tail to store the most recent (tail) or the least recent node (head)
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        // if Node is not in the map, return -1 as requested
        if (node == null) {
            return -1;
        }
        // if the node is not the lastest added one, doing the operation of relinking nodes in the LinkedList
        if (node != tail) {
            // remove the head and assign a new head if the node to get is the least recent one, else just doing the operation
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            // set the new node to tail
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // if the node does exist, update its value and apply the same operation in the get method if the node is not tail
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            // otherwise, initialize a new node with key, value pair
            Node newNode = new Node(key, value);
            // if the available capacity of the list is 0, remove its head, assign new head and add 1 for capacity
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            // if the list is empty, set the new node to head, else just add the new node to the tail and set it as new tail
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            // put the key, newNode pair to hashmap and decrease 1 for capacity
            map.put(key, newNode);
            capacity--;
        }
    }
}