package com.algo.linkedlist;

import com.algo.linkedlist.structure.SLinkedList;

import java.util.HashMap;

public class LinkedListLoopAll {

    public static void main(String[] args) {
        SLinkedList root = new SLinkedList(4);
        SLinkedList node1 = new SLinkedList(5);
        SLinkedList node2 = new SLinkedList(6);
        SLinkedList node3 = new SLinkedList(7);
        SLinkedList node4 = new SLinkedList(8);

        node4.next = node2;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        root.next = node1;

        LinkedListLoopAll sol = new LinkedListLoopAll();
        SLinkedList sLinkedList = sol.removeLoop(root);
        System.out.println(node4.next);

    }

    SLinkedList removeLoop(SLinkedList root) {
        SLinkedList matchPoint = detectLoopFCE(root);
        SLinkedList slow = root;
        SLinkedList prev = root;

        while( slow != matchPoint) {
            prev = slow;
            slow = slow.next;
            matchPoint = matchPoint.next;
        }

        prev.next = null;
        return root;
    }

    SLinkedList loopStarting(SLinkedList root) {
        SLinkedList matchPoint = detectLoopFCE(root);
        SLinkedList slow = root;

        while( slow != matchPoint) {
            slow = slow.next;
            matchPoint = matchPoint.next;
        }
        return slow;
    }


    SLinkedList detectLoopFCE(SLinkedList root) {
        SLinkedList slow = root;
        SLinkedList fast = root;

        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast) {
                return fast;
            }
        }

        return null;
    }


    int countNodesinLoop(SLinkedList head){
        //Find Loop
        SLinkedList slow = head;
        SLinkedList fast = head;

        while( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if( slow == fast) {
                break;
            }
        }


        //Find Starting of Loop
        if(slow == fast) {
            slow = head;
            int count = 1;
            while( slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            // iterate till last node
            while( slow.next != fast) {
                slow = slow.next;
                count++;
            }

            return count;
        } else {
            return 0;
        }

    }

    //Time O(N)
    //Space O(N)
    boolean detectLoop(SLinkedList root) {
        HashMap<SLinkedList, Boolean> map = new HashMap<>();

        SLinkedList temp = root;
        while( temp.next != null ) {
            if(map.containsKey(temp)) {
                return true;
            } else {
                map.put(temp, true);
            }
            temp = temp.next;
        }
        return false;
    }

    public static void detectAndRemoveLoop(SLinkedList head) {
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