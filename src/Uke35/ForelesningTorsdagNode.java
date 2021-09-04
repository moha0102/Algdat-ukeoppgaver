package Uke35;

/*
A node in a tournament tree. Each ndoe has a "pointer" to its children
*/
public class ForelesningTorsdagNode {
    public static class Node {
        char value;
        Node leftChildNode;
        Node rightChildNode;

        Node(char value) {
            this.value = value;
            this.leftChildNode = null;
            this.rightChildNode = null;
        }

        void print() {
            System.out.print(value + ", ");
            if (this.leftChildNode != null) {
                this.leftChildNode.print();

            }

            if (this.rightChildNode != null) {
                this.rightChildNode.print();
            }
        }

    }

    static Node playMatch(Node teamA, Node teamB) {
        char winner;
        if (teamA.value > teamB.value) {
            winner = teamA.value;
        } else {
            winner = teamB.value;
        }
        Node parent = new Node(winner);
        parent.leftChildNode = teamA;
        parent.rightChildNode = teamB;

        return parent;

    }

    public static void main(String[] args) {
        //Node root = new Node('S');
        Node z = new Node('Z');
        Node c = new Node('C');
        Node f = new Node('F');
        Node k = new Node('K');
        //root.print();

        Node semi_1 = playMatch(z,c);
        Node semi_2 = playMatch(f,k);

        Node winner = playMatch(semi_1, semi_2);
        //System.out.println("Vinner av semifinale:");
        //semi_1.print();
        //semi_2.print();
    
        //System.out.println("Vinner av finale:");
        //Forventer: zzzckfk
        System.out.println("Turneringstreet i pre-orden:");
        winner.print();

    }

    
}
