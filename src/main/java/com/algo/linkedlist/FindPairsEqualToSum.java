package com.algo.linkedlist;

import com.algo.linkedlist.structure.DoublyLinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindPairsEqualToSum {

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList(1);
        DoublyLinkedList l1 =  new DoublyLinkedList(2);
        DoublyLinkedList l2 =  new DoublyLinkedList(3);
        DoublyLinkedList l3 =  new DoublyLinkedList(4);
        DoublyLinkedList l4 =  new DoublyLinkedList(5);
        DoublyLinkedList l5 =  new DoublyLinkedList(6);
        DoublyLinkedList l6 =  new DoublyLinkedList(8);
        DoublyLinkedList l7 =  new DoublyLinkedList(9);

        ll.right = l1;
        l1.left = ll;
        l1.right = l2;
        l2.left = l1;
        l2.right = l3;
        l3.left = l2;
        l3.right = l4;
        l4.left = l3;
        l4.right = l5;
        l5.left = l4;
        l5.right = l6;
        l6.left = l5;
        l6.right = l7;
        l7.left = l6;

        findPairsWithGivenSum(7, ll);
    }

    //1 5 6
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DoublyLinkedList head) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, Boolean> temp = new HashMap<>();

        DoublyLinkedList start = head;
        DoublyLinkedList tail = head;

        while( tail.right != null ) {
            tail = tail.right;
        }


        while( start != tail && start != null && tail != null) {
            int sum = start.data  + tail.data;
            if( sum == target) {
                ArrayList<Integer> r = new ArrayList<>();

                if( start.data < tail.data) {
                    r.add(start.data);
                    r.add(tail.data);
                } else {
                    r.add(tail.data);
                    r.add(start.data);
                }

                if(!temp.containsKey(start.data) || !temp.containsKey(tail.data)) {
                    res.add(r);
                }

                temp.put(start.data, true);
                temp.put(tail.data, true);

                start = start.right;
                tail = tail.left;
            } else if( sum > target ) {
                tail = tail.left;
            } else {
                start = start.right;
            }
        }

        return res;
    }
}
