package 알고리즘._04_링크드_리스트;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SinglyLinkedListTest {

    SinglyLinkedList ll;

    @Before
    public void init() {
        this.ll = new SinglyLinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
    }

    @Test
    public void removeDupsTest() {
        ll.append(1);
        ll.append(2);
        ll.append(1);
        ll.append(2);

        ll.removeDups();
        ll.retrieve();

        assertThat(ll.size(), is(4));
    }

    @Test
    public void findReverseKth_2() {
        SinglyLinkedList.Node node = ll.KthToLast(ll.header, 1, new SinglyLinkedList.Reference());
        System.out.println(node);
        assertTrue(node.data.equals(4));
    }

    @Test
    public void findReverseKth_3() {
        SinglyLinkedList.Node node = ll.KthToLast(ll.header, 2);
        System.out.println(node);
        assertTrue(node.data.equals(3));
    }

    @Test
    public void deleteMiddleNode() {
        ll.deleteMiddleNode(ll.getByKth(2));
        ll.retrieve();
        assertTrue(ll.size().equals(3));
    }

}
