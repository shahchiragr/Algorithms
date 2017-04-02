package org.cshah.algorithms.hackerrank;

/**
 * Created by chirag on 4/1/17.
 */
import java.util.*;

class RangeNode implements Comparable {
    int lower, upper;
    RangeNode left, right;

    public RangeNode(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }


    public void printTree(int tab) {
        for (int i=0; i<tab;i++) {
            System.out.print("\t");
        }

        System.out.println(lower + " : " + upper );

        if (left != null) {
            left.printTree(tab+1);
        }

        if (right != null) {
            right.printTree(tab+1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RangeNode rangeNode = (RangeNode) o;

        if (lower != rangeNode.lower) return false;
        return upper == rangeNode.upper;

    }

    @Override
    public int hashCode() {
        int result = lower;
        result = 31 * result + upper;
        return result;
    }

    public int compareTo(Object var1) {
        RangeNode node = (RangeNode)var1;

        if (lower - node.lower < 0)
            return  -1;
        else if (lower - node.lower > 0)
            return  1;
        else if (upper - node.upper < 0)
            return -1;
        else if (upper - node.upper > 0)
            return  1;

        return  0;
    }

}

class RangeModule  {
    RangeNode root;

    public void AddRange(int lower, int upper) {
        boolean foundNode = findNode(lower, upper, root);

        if (foundNode) {
            System.out.println("Node already exists...");
            return;
        }

        root = AddRangeImpl(lower, upper,root);
    }

    public void printNode() {
        if (root == null) {
            return;
        }

        root.printTree(0);
    }

    private RangeNode AddRangeImpl(int lower, int upper, RangeNode root) {
        if (root == null) {
            RangeNode newNode = new RangeNode(lower, upper);
            return newNode;
        }

        if (lower <= root.lower) {
            root.left = AddRangeImpl(lower,upper, root.left);
        } else if (lower > root.lower) {
            root.right = AddRangeImpl(lower,upper,root.right);
        }

        return root;
    }

    public boolean findNode(int lower, int upper, RangeNode root) {
         if (root == null)
             return  false;

        if (root.lower == lower && root.upper == upper)
            return true;

        if (lower <= root.lower) {
            return findNode(lower,upper, root.left);
        } else {
            return  findNode(lower, upper, root.right);
        }

        //return false;
    }


    public boolean QueryRange(int lower, int upper) {
        if (root == null)
            return false;

        if (upper < lower)
            return false;

        List<RangeNode> list = new ArrayList<RangeNode>();
        boolean bval = QueryRangeIntl(lower, upper,root,list);

//       for (RangeNode n : list) {
//            System.out.println(" NODE " + n.lower + " : " + n.upper);
//        }

        return  bval;
    }

    private boolean between(int lower, int upper, int number) {
        return (number >= lower && number <= upper);
    }

    private boolean QueryRangeIntl(int lower, int upper, RangeNode root, List<RangeNode> list) {
        if (root == null)
            return false;

    //    System.out.println("HERE " + lower + ":" + upper + ":" + root.lower + ":" + root.upper);
        if ( lower >= root.lower && lower <= root.upper && upper <= root.upper) {
            list.add(root);
            return true;
        }


        if (root.left != null && lower < root.lower) {
            if (QueryRangeIntl(lower, (upper < root.lower ? upper : root.lower-1), root.left, list)) {
                //list.add(root);
              //  System.out.println("=== " + upper + ":" + root.upper);
                if (upper >= root.lower) {
                    return QueryRangeIntl(root.lower, upper, root, list);

                } else {
                    //check local node and return
                    return true;
                }
          } else {
                return  false;
            }
        }

        if (root.right != null && upper > root.upper) {
            if (QueryRangeIntl((lower < root.upper ? root.upper + 1 : lower), upper, root.right, list)) {
                return  true;
            } else {
                return false;
            }
        }

        return false;
    }

    public void DeleteRange(int lower, int upper) {
        if (root== null)
            return;

        //we have to delete this root node
        if  (between(root.lower, root.upper, lower) && between(root.lower,root.upper, upper)) {

            int lower1 = root.lower;
            int upper1 = lower-1;

            int lower2 = upper+1;
            int upper2 = root.upper;

        //    System.out.println(lower1 + ":" + upper1 + " === " + lower2  + ":" + upper2);

            RangeNode newRoot = deleteNode(root,root);

            root = newRoot;

            if (lower1 < upper1) {
                AddRange(lower1, upper1);
            }

            if (lower2 < upper2) {
                AddRange(lower2, upper2);
            }

        } else {

            //TODO
            List<RangeNode> nodesTobeDeleted = new ArrayList<RangeNode>();
            getDeletedNodeList(lower, upper, root, nodesTobeDeleted);

//            for (RangeNode nn : nodesTobeDeleted) {
//                System.out.println("DELETED " + nn.lower + ":" + nn.upper);
//            }

            for (RangeNode nn : nodesTobeDeleted) {
                    if (between(nn.lower, nn.upper,lower)) {
                        RangeNode newNode = deleteNode(root, nn);
                        root= newNode;
                        AddRange(nn.lower, lower-1);

                        if (between(nn.lower, nn.upper,upper)) {
                            AddRange(upper+1, nn.upper);
                        }

                    } else if (between(nn.lower, nn.upper, upper)) {
                        RangeNode newNode =  deleteNode(root, nn);
                        root = newNode;
                        AddRange(upper+1, nn.upper);
                    }
             }

        }
        //if ()
    }


    private void getDeletedNodeList(int lower, int upper, RangeNode root, List<RangeNode> list) {
        if (root == null)
            return;

        if (between(root.lower, root.upper, lower)) {
            if (!list.contains(root))
                list.add(root);
        } else if (between(root.lower, root.upper, upper)) {
            if (!list.contains(root)) {
                list.add(root);
            }
        }

        getDeletedNodeList(lower, upper, root.left, list);
        getDeletedNodeList(lower, upper, root.right, list);



    }

    private RangeNode deleteNode(RangeNode root, RangeNode nodeToBeDeleted) {
        if (root == null)
            return null;


        if (nodeToBeDeleted.compareTo(root) <  0) {
            root.left = deleteNode(root.left, nodeToBeDeleted);
        } else if (nodeToBeDeleted.compareTo(root) > 0) {
            root.right = deleteNode(root.right, nodeToBeDeleted);
        } else {
            if (root.left != null && root.right != null) {
                RangeNode temp = root;
                //find minimum node from right
                RangeNode minRightNode = minimumNode(root.right);
                root.upper = minRightNode.upper;
                root.lower = minRightNode.lower;
                root.right = deleteNode(root.right, minRightNode);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                return  null;
            }
        }

        return root;

    }

    private RangeNode minimumNode(RangeNode node) {
        if (node.left == null)
            return node;
        else
            return  minimumNode(node.left);
    }
};

public class RangeModuleImpl {

    public static void main(String args[]) {
        RangeModule rm = new RangeModule();
  /*
        rm.AddRange(110,150);
        rm.AddRange(50,109);
        rm.AddRange(151,180);
        rm.AddRange(185,300);

        rm.printNode();

        int lower = 60;
        int upper = 90;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower =60;
        upper = 120;

        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower =45;
        upper = 90;

        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower =109;
        upper = 150;

        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));


        lower = 151;
        upper = 170;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower = 121;
        upper = 170;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));


        lower = 60;
        upper = 160;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        */
/*

        rm.AddRange(10,200);
        rm.AddRange(150,180);
        rm.AddRange(250,500);
        rm.printNode();

        int lower = 50;
        int upper = 100;

        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower = 180;
        upper = 300;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));


        rm.DeleteRange(50,150);

        rm.printNode();
        lower = 50;
        upper = 100;

        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        */

        rm.AddRange(10,100);

        int lower = 10;
        int upper = 100;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        rm.DeleteRange(25,44);

        rm.printNode();

        lower = 10;
        upper = 100;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));


        lower = 10;
        upper = 25;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower = 44;
        upper = 50;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower = 10;
        upper = 24;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

        lower = 50;
        upper = 60;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));


        System.out.println("================");
        rm.printNode();
        System.out.println("================");

        rm.DeleteRange(15,50);
        rm.printNode();
        System.out.println("================");

        rm.DeleteRange(60,70);
        rm.printNode();
        System.out.println("================");

        lower = 15;
        upper = 50;
        System.out.println("Query for " + lower + " , " + upper + " === " +  rm.QueryRange(lower, upper));

/*
        rm.AddRange(110,150);
        rm.AddRange(50,109);
        rm.AddRange(151,180);
        rm.AddRange(185,300);

        rm.printNode();
        System.out.println("================");

        rm.DeleteRange(51, 140);

        rm.printNode();
        System.out.println("================");
*/
    }
}
