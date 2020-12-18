package algorithm;

import algorithm.graph.GraphTraversal;
import org.junit.jupiter.api.Test;

/**
 * @author traeper
 */
public class GraphTraversalTest {

    @Test
    void dfsRecursiveTest() {
        GraphTraversal graph = new GraphTraversal(10);
        graph.connect(0, 1);
        graph.connect(0, 2);
        graph.connect(0, 3);
        graph.connect(1, 2);
        graph.connect(1, 4);
        graph.connect(1, 5);
        graph.connect(1, 7);
        graph.connect(3, 8);
        graph.connect(5, 6);
        graph.connect(6, 9);

        /*
        DFS Started. from 1
        visit 1
        visit 0
        visit 2
        visit 3
        visit 8
        visit 4
        visit 5
        visit 6
        visit 9
        visit 7
         */
        graph.dfs(1);

        /*
         BFS Started. from 1
         visit 1
         visit 0
         visit 2
         visit 4
         visit 5
         visit 7
         visit 3
         visit 6
         visit 8
         visit 9
         */
        graph.bfs(1);
    }
}
