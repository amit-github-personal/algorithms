package com.algo.tree;

import com.algo.linkedlist.structure.DoublyLinkedList;

import java.util.ArrayDeque;
import java.util.Queue;

public class NextRightNode {

    DoublyLinkedList nextRight(DoublyLinkedList root, int key) {
        Queue<DoublyLinkedList> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(null);
        boolean previousMatch = false;

        while(!queue.isEmpty()) {
            DoublyLinkedList current = queue.poll();

            if( current == null && previousMatch) {
                return new DoublyLinkedList(-1);
            }

            if(current == null) {
                if(queue.isEmpty()) {
                    return new DoublyLinkedList(-1);
                }
                queue.add(null);
                continue;
            } else {
                if(previousMatch) {
                    return current;
                }
                previousMatch = current.data == key ? true : false;
            }


            if(current.left != null ) {
                queue.add(current.left);
            }

            if(current.right != null ) {
                queue.add(current.right);
            }
        }

        return new DoublyLinkedList(-1);
    }
}
