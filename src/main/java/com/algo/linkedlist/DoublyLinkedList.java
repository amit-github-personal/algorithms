package com.algo.linkedlist;

public class DoublyLinkedList {
    int data;
    DoublyLinkedList left;
    DoublyLinkedList right;

    public DoublyLinkedList(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
