package 알고리즘._03_트리_그래프;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Tree {

    @AllArgsConstructor
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public Node root;

    public static Node makeNode(Node left, int data, Node right) {
        return new Node(data, left, right);
    }

    public static void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public static void preorder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }

}

