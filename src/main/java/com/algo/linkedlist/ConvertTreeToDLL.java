package com.algo.linkedlist;

public class ConvertTreeToDLL {


    public static void main(String[] args) {
        DoublyLinkedList node = new DoublyLinkedList (1);
        node.left = new DoublyLinkedList (3);
        node.right = new DoublyLinkedList (2);

        ConvertTreeToDLL sol = new ConvertTreeToDLL ();
        DoublyLinkedList node1 = sol.bToDLL (node);
        System.out.println (" node");

    }

    DoublyLinkedList head = null;
    DoublyLinkedList temp = null;

    //Function to convert binary tree to doubly linked list and return it.
    DoublyLinkedList bToDLL(DoublyLinkedList root) {
        convert (root);
        return head;
    }

    void convert(DoublyLinkedList root) {
        if (root == null) {
            return;
        }

        convert (root.left);

        DoublyLinkedList newNode = new DoublyLinkedList (root.data);

        if (head == null) {
            head = newNode;
            temp = newNode;

        } else {
            temp.right = newNode;
            DoublyLinkedList temp1 = temp;
            temp = temp.right;
            temp.left = temp1;
        }

        convert (root.right);
    }
}
