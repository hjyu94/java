package 알고리즘._99_문제풀이.easy._03_트리_그래프;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BST에서_최소_diff_구하기 {
    /* --------------------------------------------------------------------------------------------------
        530. Minimum Absolute Difference in BST
        (https://leetcode.com/problems/minimum-absolute-difference-in-bst/)

        Given a binary search tree with non-negative values,
        find the minimum absolute difference between values of any two nodes.

        Example:

        Input:

           1
            \
             3
            /
           2

        Output:
        1

        Explanation:
        The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


        Note:

        There are at least two nodes in this BST.
        This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
    --------------------------------------------------------------------------------------------------------- */
    // 이진검색트리 성질: inorder -> 오름차순 정렬이 됨
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ************************* 내 풀이 ******************************
    public int getMinimumDifference_Mine(TreeNode root) {
        // 트리의 원소들 가져오기
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        // 원소들 중 2개를 뽑아서 최소 diff 구하기
        List<Integer> diffs = new ArrayList<>();
        for(int i=0; i<nums.size(); ++i) {
            for(int j=i+1; j<nums.size(); ++j) {
                Integer diff = nums.get(j) - nums.get(i);
                diffs.add(diff);
            }
        }
        Collections.sort(diffs);
        return diffs.get(0);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    // ************************* 유튜브 풀이 ******************************
    // https://youtu.be/KLX44z_NnYc

    boolean init;
    int min, prev;

    public int getMinimumDifference(TreeNode root) {
        init = false;
        min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {
        if(root == null)
            return;

        // left
        inorder(root.left);

        // self 처리
        if(!init) {
            init = true;
        } else {
            min = Math.min(min, root.val-prev);
        }
        prev = root.val;

        // right
        inorder(root.right);
    }

    @Test
    public void getMinimumDifferenceTest() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        n1.right = n3;
        n3.left = n2;

        assertEquals(getMinimumDifference_Mine(n1), 1);
    }
}
