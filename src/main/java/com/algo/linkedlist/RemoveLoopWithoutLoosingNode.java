package com.algo.linkedlist;

public class RemoveLoopWithoutLoosingNode {

    public static void removeLoop(SLinkedList head) {
        SLinkedList slow = head;
        SLinkedList fast = head;
        SLinkedList prev = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (slow == fast) {
            fast = head;
            while (slow != fast) {
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }

            prev.next = null;
        } else return;
    }
}

