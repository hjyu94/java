package 알고리즘._03_트리_그래프;

import org.junit.Before;
import org.junit.Test;

public class TreeTest {
    /*
                1
              /   \
            2       3
          /   \
        4       5
    */
    Tree t = null;

    @Before
    public void makeTree() {
        t = new Tree();
        Tree.Node n4 = t.makeNode(null, 4, null);
        Tree.Node n5 = t.makeNode(null, 5, null);
        Tree.Node n2 = t.makeNode(n4, 2, n5);
        Tree.Node n3 = t.makeNode(null, 3, null);
        Tree.Node n1 = t.makeNode(n2, 1, n3);
        t.setRoot(n1);
    }

    @Test
    public void inorder() {
        t.inorder(t.getRoot());
    }

    @Test
    public void preorder() {
        t.preorder(t.getRoot());
    }

    @Test
    public void postorder() {
        t.postorder(t.getRoot());
    }
}


