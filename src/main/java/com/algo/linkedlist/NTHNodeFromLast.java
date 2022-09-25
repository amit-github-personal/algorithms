package com.algo.linkedlist;

import com.algo.linkedlist.structure.SLinkedList;

public class NTHNodeFromLast {

    int getNthFromLast(SLinkedList head, int n) {

        int size = getSize(head);

        if( size < n) return -1;
        int nodePos = size - n;

        for(int i = 0; i < nodePos; ++i) {
            head = head.next;
        }
        return head.data;
    }

    int getSize(SLinkedList head) {
        if ( head == null ) return 0;

        int count = 1;

        while( head.next != null ) {
            head = head.next;
            count++;
        }

        return count;
    }
}
