package 알고리즘._04_링크드_리스트;

// https://www.youtube.com/watch?v=IrXYr7T8u_s&list=PLjSkJdbr_gFZQp0KEoo0Y4KkCI5YqxtjZ&index=4

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class SinglyLinkedList {

    Node header;

    @Getter
    @Setter
    @ToString
    static class Node {
        Integer data = null;
        Node next = null;
    }

    SinglyLinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    Integer size() {
        Node n = header;
        int size = 0;
        while (n.next != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    public Node getByKth(int k) {
        Node n = header;
        for(int i=0; i<k; ++i) {
            n = n.next;
        }
        return n;
    }

    // *** Quiz1: 정렬되지 않은 Linked List가 있을 때 중복값을 제거해라
    // 단 별도의 버퍼를 사용하지 않아야 한다
    // 버퍼: 어떤 장치에서 다른 장치로 데이터를 송신할 때 일어나는 시간의 차이나 데이터 흐름의 속도 차이를 조정하기 위해 일시적으로 데이터를 기억시키는 장치.
    // (별도의 버퍼를 사용 가능할 때는 hash set 을 사용해 중복을 제거하면 쉽다)
    // (https://www.youtube.com/watch?v=Ce4baygLMz0&list=PLjSkJdbr_gFZQp0KEoo0Y4KkCI5YqxtjZ&index=6)
    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (r.next.data == n.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    // *** Quiz2: https://youtu.be/Vb24scNDAVg
    // 단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오
    // 단, 재귀적으로 구현하시오.
    /*
        // 재귀적으로 풀라는 조건이 없으면 아래와 같이 풀면 됨
        public Node KthToLast(int k) {
            Node n = header;
            int size = 0;
            while (n.next != null) {
                size++;
                n = n.next;
            }
            if (k >= size) {
                System.out.println("bound error");
                return null;
            }
            n = header;
            for (int i = 0; i < size - k + 1; ++i) {
                n = n.next;
            }
            return n;
        }
     */

    // [방법1] 그런데 이 방법은 k 번째 노드를 반환하는 방법이 아님.
    static public int KthToLast_similar(Node n, int k) {
        if (n == null) {
            return 0;
        }
        int count = KthToLast_similar(n.next, k) + 1;
        if (count == k) {
            System.out.println(k + "th to last node is " + n.data);
        }
        return count;
    }

    // [방법2]
    // C++는 레퍼런스 변수를 사용해서 output을 하나 더 추가할 수 있는데
    // 자바는 통하지 않음 -> Reference 객체를 새로 만들고 거기에 count 를 저장하자.
    static class Reference {
        int count = 0;
    }

    static public Node KthToLast(Node n, int k, Reference r) {
        if (n == null) {
            return null;
        }
        Node found = KthToLast(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return found;
    }

    // [방법3]
    // 가리키는 노드가 k개 차이나는 2개의 포인터를 사용하자.
    // p1 <--k--> p2
    // p2가 null이 되면 p1이 k번째 노드가 된다.
    static public Node KthToLast(Node first, int k) {
        Node p1 = first;
        Node p2 = first;
        for(int i=0; i<k; ++i) {
            p2 = p2.next;
        }
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // *** Quiz3:
    // 단방향 링크드 리스트에서 중간에 있는 노드를 삭제하시오
    // 단 당신은 첫번째 노드가 어디있는지 모르고 오직 삭제할 노드만 갖고 있다.
    public boolean deleteMiddleNode(Node n) {
        // 앞이나 맨 끝의 노드는 삭제할 수 없다.
        if(n == null || n.next == null) {
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

}