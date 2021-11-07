package Uke43.ForelesningTirsdag;

import java.util.Arrays;
import java.util.Objects;

public class binarySearchTree {
    public static void main(String[] args) {
        BST tree = new BST();
        int[] values = {9,7,1,3,5,11,13,10,8};
        for (int i = 0; i < values.length; i++) {
            tree.insert(values[i]);
        }

        System.out.println();
    }
    
    public static class Node {
        Node parent;
        Node left;
        Node right;
        int value;
        
        Node(int value) {
            this.value = value;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.left = null;
            this.right = null;
        }

        Node(Node parent, Node left, Node right, int value) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Binary sarch tree klasse som har rotnoden og annet info om vårt søketre
     * har også metoden for innlegging, fjerning, søking, etc
     */

    public static class BST {
        Node root;

        void insert(int value) {
            Objects.requireNonNull(value, "Value kan ikke være null");
            // Treet vårt er tomt, vi lager første node
            if (root == null)  {
                root = new Node(value);
                return;
            } else {
                Node p = root;
                Node q = null; //Parent til p

                while (p != null) {
                    q = p;
                    if(p.value <= value) {
                        p = p.right;
                    } else {
                        p = p.left;
                    }
                }
                //Nå har vi funnet hvor den nye noden skal ligge
                //Nye noden skal være høyre eller venstre barn av q
                    if (value >= q.value) {
                        q.right = new Node(value,q);
                    } else {
                        q.left = new Node(value, q);
                    }
                }
            }




        }

}

