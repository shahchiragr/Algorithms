package com.example.algorithms.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by chirag on 9/10/16.
 */
public class SufixTree {
    SuffixTreeNode root = new SuffixTreeNode();

    public SufixTree(String s) {
        for (int i=0; i < s.length(); i++) {
            String suff1 = s.substring(i);
            root.insertString(suff1, i);
        }
    }

    public  boolean getIndexes(String s) {
        return root.getIndexes(s) == s.length();
    }

    class SuffixTreeNode {
        HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
        char value;
        ArrayList<Integer> indexes = new ArrayList<Integer>();

        public void insertString(String suff, int  index) {
            indexes.add(index);
            if (suff != null && suff.length() >0) {
                value = suff.charAt(0);
                SuffixTreeNode node = null;
                if (children.containsKey(value)) {
                    node = children.get(value);
                } else {
                    node = new SuffixTreeNode();
                    children.put(value, node);
                }

                String remainder = suff.substring(1);
                node.insertString(remainder, index);
            }
        } //insert

        public int getIndexes(String s ) {
            if (s == null || s.length() == 0)
                return 0;

            int count = 0;
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                count = 1 + children.get(first).getIndexes(remainder);
            }

            return  count;
        }
    }

    public static void main(String args[]) {
        String test = "chirag";
        SufixTree suffixTree = new SufixTree(test);
        String ss[] =  {"chi", "cs", "cx", "chirag", "ir", "ra"};

        for (String str : ss) {
            System.out.println( str + " exists " + suffixTree.getIndexes(str));
        }
    }
}
