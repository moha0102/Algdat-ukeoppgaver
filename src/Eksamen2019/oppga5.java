package Eksamen2019;

public class oppga5 {
    public static class DoubleLinkedList {
        public class Node {
            Node next;
            Node prev;
            char value;
        }

        Node head;
        Node tail;

        void addLast(char value) {...}

        void addFirst(char value) {...}

        char removeLast() {...}

        char removeFirst() {...}

        void print() {...}

        void remove(int index) {
            if (index == 0) {
                removeFirst();
            } else if (index == size - 1) {
                removeLast();
            } else {
                for (int i = 0; i < size; i++) {
                    if (i == index) {
                        removeFirst();
                    } else {
                        addLast(removeFirst());
                    }
                }
            }
        }

        void remove(char value) {
            int count = 0;
            if (head.value == value) {
                removeFirst();
            } else if (tail.value == value) {
                removeLast();
            } else {
                for (int i = 0; i < size; i++) {
                    if (head.value == value && count < 1) {
                        removeFirst();
                        count++;
                    } else {
                        addLast(removeFirst());
                    }
                }
            }
            count = 0;
        }
    }
}
