package com.algo.linkedlist.structure;

public class DoublyLinkedList {
    public int data;
    public DoublyLinkedList left;
    public DoublyLinkedList right;

    public DoublyLinkedList(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
