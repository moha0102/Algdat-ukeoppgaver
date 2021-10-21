package Uke42.ForelesningMandag;

import java.util.ArrayDeque;

public class BinaryTree {
    public static class BinaryTreeNode {
        char value;
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;

        BinaryTreeNode(char value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public BinaryTreeNode addLeftChild(char value) {
            this.leftChild = new BinaryTreeNode(value);
            return this.leftChild;
        }

        public BinaryTreeNode addRightChild(char value) {
            this.rightChild = new BinaryTreeNode(value);
            return this.rightChild;
        }
    }

    public static void printLevelOrder(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();
        //Legger til rot-noden
        queue.addLast(root);

        while (!queue.isEmpty()) {
            //Tar ut første fra køen
            BinaryTreeNode current = queue.removeFirst();

            //Legg til current sine to barn til køen
            if(current.leftChild != null) {
                queue.addLast(current.leftChild);
            }

            if (current.rightChild != null) {
                queue.addLast(current.rightChild);
            }

            System.out.print(current.value + " ");
        }
    }

    public static void printPreOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    public static void printInOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.leftChild);
        System.out.print(node.value + " ");
        printInOrder(node.rightChild);
    }

    public static void printDepthFirstNonRecursive(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<BinaryTreeNode>();
        
        stack.addLast(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode current = stack.removeLast();

            if (current.rightChild != null) {
                stack.addLast(current.rightChild);
            }

            if (current.leftChild != null) {
                stack.addLast(current.leftChild);
            }
            System.out.print(current.value + " ");
        }
    }

    public static void printPostOrder(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.leftChild);
        printPostOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        //legger rot-noden
        BinaryTreeNode root = new BinaryTreeNode('A');

        //Legg inn resterende noder på nivå 1
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        //Legg inn alle node på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        //printLevelOrder(root);
        System.out.println("Pre-Order:");
        printPreOrder(root);
        System.out.println("");
        System.out.println("In-Order:");
        printInOrder(root);
        System.out.println("");
        System.out.println("Post-Order:");
        printPostOrder(root);
        System.out.println();


        System.out.println("NonRecursive");
        printDepthFirstNonRecursive(root);

    }
}
