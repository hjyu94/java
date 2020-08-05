package 알고리즘._99_문제풀이.easy._04_링크드_리스트;

import org.junit.Test;

public class 두_링크드_리스트_병합하기 {
    /*
        21. Merge Two Sorted Lists
        (https://leetcode.com/problems/merge-two-sorted-lists/description/)

        Merge two sorted linked lists and return it as a new sorted list.
        The new list should be made by splicing together the nodes of the first two lists.

        Example:
            Input: 1->2->4, 1->3->4
            Output: 1->1->2->3->4->4
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rv = null;

        boolean init = false;
        ListNode iter = null;

        while(l1!=null && l2!=null) {
            int min = l1.val < l2.val? l1.val : l2.val;
            ListNode newNode = new ListNode(min);

            if(!init) {
                rv = newNode;
                iter = newNode;
                init = true;
            } else {
                iter.next = newNode;
                iter = iter.next;
            }

            if(l1.val < l2.val) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }

        while(l1 != null) {
            ListNode newNode = new ListNode(l1.val);
            if(!init) {
                rv = newNode;
                iter = newNode;
                init = true;
            } else {
                iter.next = newNode;
                iter = iter.next;
            }
            l1 = l1.next;
        }
        while(l2 != null) {
            ListNode newNode = new ListNode(l2.val);
            if(!init) {
                rv = newNode;
                iter = newNode;
                init = true;
            } else {
                iter.next = newNode;
                iter = iter.next;
            }
            l2 = l2.next;
        }

        return rv;
    }

    @Test
    public void mergeTwoListsTest() {
        ListNode n1_2 = new ListNode(4);
        ListNode n1_1 = new ListNode(2, n1_2);
        ListNode n1_0 = new ListNode(1, n1_1);

        ListNode n2_2 = new ListNode(4);
        ListNode n2_1 = new ListNode(3, n2_2);
        ListNode n2_0 = new ListNode(1, n2_1);

        mergeTwoLists(n1_0, null);
//        mergeTwoLists(null, null);
    }
}