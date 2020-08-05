package 알고리즘._99_문제풀이.easy._03_트리_그래프;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class N_ary_Tree_Preorder_Traversal {

    /********************************************************************
     * 589. N-ary Tree Preorder Traversal
     * (https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/)
     * (https://youtu.be/jHSoaw0pFe4)
     *
     * Given an n-ary tree, return the preorder traversal of its nodes' values.
     *
     * Nary-Tree input serialization is represented in their level order traversal,
     * each group of children is separated by the null value (See examples).
     *
     * Follow up:
     *
     * Recursive solution is trivial, could you do it iteratively?
     *
     * Constraints:
     *
     * The height of the n-ary tree is less than or equal to 1000
     * The total number of nodes is between [0, 10^4]
     */

    /****************** Definition for a Node. ******************/
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /************************ 내 풀이 ****************************/
    public List<Integer> preorder_mine(Node root) {
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        // exception
        if (root == null) {
            return answer;
        }

        // init
        stack.push(root);

        // 꺼담출
        while (!stack.isEmpty()) {
            Node pop = stack.pop();

            // put element to stack by reverse order
            List<Node> children = pop.children;
            for (int i = children.size() - 1; i >= 0; --i) {
                stack.push(children.get(i));
            }

            answer.add(pop.val);
        }

        return answer;
    }

    /************************ 유튭 풀이 ****************************/
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        traverse(root, ret);
        return ret;
    }

    private void traverse(Node node, List<Integer> ret) {
        if(node == null) {
            return;
        }
        ret.add(node.val);
        for(Node child : node.children) {
            traverse(child, ret);
        }
    }
}
