package com.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CycleDetect {
    @Test
    public void test1() {
        SinglyLinkedListNode fifth = new SinglyLinkedListNode(5);
        SinglyLinkedListNode fourth = new SinglyLinkedListNode(4, fifth);
        SinglyLinkedListNode third = new SinglyLinkedListNode(3, fourth);
        SinglyLinkedListNode second = new SinglyLinkedListNode(2, third);
        SinglyLinkedListNode root = new SinglyLinkedListNode(1, second);
        fifth.next = third;
        assertTrue(hasCycle(root));
    }
    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next = null;
        SinglyLinkedListNode(int data) {
            this.data = data;
        }
        SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public boolean hasCycle(SinglyLinkedListNode head) {
        // Floyd's Tortoise and hare
        if (head == null) {return false;}
        SinglyLinkedListNode fast = head;
        SinglyLinkedListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;

    }
}
