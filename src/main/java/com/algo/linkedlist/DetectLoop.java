package com.algo.linkedlist;

public class DetectLoop {

    public static boolean detectLoop(SLinkedList head){
        SLinkedList slow = head;
        SLinkedList fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
