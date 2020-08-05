package 알고리즘._99_문제풀이.easy._04_링크드_리스트;

public class 링크드_리스트의_가운데_값_출력 {
    /*
        876. Middle of the Linked List
        (https://leetcode.com/problems/middle-of-the-linked-list/description/)

        Given a non-empty, singly linked list with head node head,
        return a middle node of linked list.

        If there are two middle nodes, return the second middle node.

        Example 1:
            Input: [1,2,3,4,5]
            Output: Node 3 from this list (Serialization: [3,4,5])
            The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
            Note that we returned a ListNode object ans, such that:
            ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.

        Example 2:
            Input: [1,2,3,4,5,6]
            Output: Node 4 from this list (Serialization: [4,5,6])
            Since the list has two middle nodes with values 3 and 4, we return the second one.

        Note:
            The number of nodes in the given list will be between 1 and 100.
    */

    /***************************************************************
     * Definition for singly-linked list.
     ***************************************************************/
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /************************** 내 풀이 *****************************/
    // 2 Path 방식.
    // 우선 전체 사이즈를 계산해, 중간 인덱스를 계산해서 다시 iteration 을 돌아 노드 찾기
    public ListNode middleNode_1(ListNode head) {
        int size = 0;
        ListNode iter = head;
        while(iter != null) {
            iter = iter.next;
            size++;
        }
        // X
        // 1            1   0
        // 1, 2         2   1
        // 1, 2, 3      2   1
        // 1, 2, 3, 4   3   2
        if(size == 0) {
            return null;
        }
        int targetIdx = size/2;
        iter = head;
        for(int i=0; i<targetIdx; ++i) {
            iter = iter.next;
        }
        return iter;
    }

    /************************** 유튭 풀이 *****************************/
    // walker, runner 테크닉
    // walker: 한번에 한칸씩, runner: 한번에 두칸씩
    // runner가 끝나면 walker는 중간에 와있음
    public ListNode middleNode_2(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        head = newHead;

        ListNode point1 = head;
        ListNode point2 = head;

        while(point2 != null) {
            point1 = point1.next;
            if(point2.next == null) break;
            point2 = point2.next.next;
        }

        return point1;
    }
}
