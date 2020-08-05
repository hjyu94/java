package 알고리즘._03_트리_그래프;

import 알고리즘._02_스택_큐.Queue;
import 알고리즘._02_스택_큐.Stack;

import java.util.LinkedList;

public class Graph {
    class Node {
        int data;
        boolean marked = false;
        LinkedList<Node> adjacent = new LinkedList<>();

        Node(int data) {
            this.data = data;
        }
    }

    Node[] nodes; // 그래프의 노드 갯수는 고정이라고 하자.

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; ++i) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    // **************************************
    // *                Search              *
    // **************************************

    private void visit(Node node) {
        System.out.print(node.data);
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        root.marked = true;

        // 꺼담출
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node nodeIter : pop.adjacent) {
                if (!nodeIter.marked) {
                    nodeIter.marked = true;
                    stack.push(nodeIter);
                }
            }
            visit(pop);
        }
    }

    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.add(root);
        root.marked = true;

        // 꺼담출
        while (!queue.isEmpty()) {
            Node pop = queue.remove();
            for (Node nodeIter : pop.adjacent) {
                if (!nodeIter.marked) {
                    nodeIter.marked = true;
                    queue.add(nodeIter);
                }
            }
            visit(pop);
        }
    }

    void dfsR(Node r) {
        if (r == null) return;
        r.marked = true;
        visit(r);

        for (Node n : r.adjacent) {
            if (n.marked == false) {
                dfsR(n);
            }
        }
    }

    void dfsR(int index) {
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR() {
        dfsR(0);
    }

    void initMarks() {
        for (Node n : nodes) {
            n.marked = false;
        }
    }

    // ************************************
    // *                Quiz              *
    // ************************************

    /*
        Q1. 두 노드간 경로가 존재하는가?
        BFS 로 모든 노드를 순회하면서 두 노드 사이의 경로가 유무 return

        DFS 로 해도 되긴 된다. 그런데 쭈욱 들어갔다가 나왔다를 반복하는 것보다 - DFS
        시작 노드 주위로 탐색하는게 더 나을 거 같아서 - BFS
    */
    boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    boolean search(Node start, Node end) {
        initMarks();

        // BFS 큐 - 꺼담출
        LinkedList<Node> q = new LinkedList<>(); // 큐로 링크드리스트를 사용하자
        q.add(start);
        while(!q.isEmpty()) {
            Node pop = q.removeFirst();
            if(pop == end) {
                return true;
            }
            for(Node iter : pop.adjacent) {
                if(iter.marked == false) {
                    q.add(iter);
                    iter.marked = true;
                }
            }
        }

        return false;
    }
}