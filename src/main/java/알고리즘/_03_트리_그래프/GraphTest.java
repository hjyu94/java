package 알고리즘._03_트리_그래프;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/*
        0
       /
      1 -- 3     7
      |  / | \  /
      | /  |   5
      2 -- 4    \
                 6 - 8
*/
public class GraphTest {

    Graph g = null;

    @Before
    public void makeGraph() {
        g = new Graph(9);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 7);
        g.addEdge(6, 8);
    }

    @Test
    @DisplayName("DFS, BFS 테스트")
    public void GraphSearchTest() {
        g.initMarks();
        g.dfs();
        System.out.println();

        g.initMarks();
        g.bfs();
        System.out.println();

        g.initMarks();
        g.dfsR();
        System.out.println();
    }

    @Test
    @DisplayName("두 노드를 잇는 경로 유무 파악하기")
    public void searchBetweenPath() {
        // System.out.println(g.search(1, 8));
        System.out.println(g.search(6, 8));
    }
}