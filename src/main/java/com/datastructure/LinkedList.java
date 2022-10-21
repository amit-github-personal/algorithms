package com.datastructure;

public class LinkedList {
    Node head = null;
    Node tail = head;
    int size = 0;

    public LinkedList(int data) {
        this.head = new Node(data);
        this.tail = head;
        size++;
    }

    public void addAtEnd(int data) {
        tail.next = new Node(data);
        tail = tail.next;
        size++;
    }

    public void insertFirst(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public int insertAfter(int existing, int data) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == existing)
                break;
            temp = temp.next;
        }

        if (temp != null) {
            Node node = new Node(data);
            node.next = temp.next;
            temp.next = node;
            size++;
            return 1;
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }

    public void reverse() {
        // Initialize three pointers current as head next as NULL and prev as Null
        Node current = head;
        Node prev = null;
        Node next = null;

        //Iterate till end of the list
        while( current != null ) {
            //Store reference to next link
            next = current.next;
            //assign prev to current next
            current.next = prev;
            //prev == curr
            prev = current;
            // curr will point to next
            current = next;
        }
        head = prev;
    }

    public void delete(int val) {
        //check if tail is the node we want to delete
        //Remove if correct
        if (tail.data == val) {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            tail = temp;
        }

    }
    
    public int getAt(int position) {
        int size = getSize();
        
        // Check index bounds
        if(position >= size) return -1;

        // check if it's the first index
        if( position -1 == 0) return head.data;

        //Find the required node
        Node temp = head;
        
        int counter = 0;
        while(counter != position) {
            temp = temp.next;
            counter++;
        }
        return temp.data;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

class Node {
    public Node next;
    public int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListTest {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(5);
        ll.addAtEnd(4);
        ll.addAtEnd(6);
        ll.insertFirst(12);
        

        System.out.println(ll.getAt(5));;
    }
}