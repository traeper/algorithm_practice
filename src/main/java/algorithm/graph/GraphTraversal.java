package algorithm.graph;

import dataStructure.queueStack.QueueByStack;

/**
 * @author traeper
 * bidirectional graph
 */
public class GraphTraversal {

    // 인접행렬이므로 공간 복잡도가 정점의 제곱수만큼 높음. 밀집(dense) 그래프인 경우 활용하기 좋음.
    // 희소(sparse) 그래프는 LinkedList 자료구조가 공간 효율적임.
    int[][] adj;

    /**
     * @param n 노드 갯수
     */
    public GraphTraversal(int n) {
        this.adj = new int[n][n];
    }

    public void connect(int i, int j) {
        adj[i][j] = 1;
        adj[j][i] = 1;
    }

    /**
     * @param s : start
     */
    public void dfs(int s) {
        System.out.printf("DFS Started. from %d%n", s);
        int[] visited = new int[adj.length];
        visit(s);
        visited[s] = 1;
        dfsInternal(visited, s);
    }

    private void dfsInternal(int[] visited, int s) {
        for (int i = 0; i < adj.length; i++) {
            if (visited[i] != 1 && adj[s][i] == 1) {
                visit(i);
                visited[i] = 1;
                dfsInternal(visited, i);
            }
        }
    }

    public void bfs(int s) {
        System.out.printf("BFS Started. from %d%n", s);
        int[] checked = new int[adj.length];
        QueueByStack<Integer> queue = new QueueByStack<>();

        queue.enqueue(s);
        checked[s] = 1;
        while (queue.size() > 0) {
            int v = queue.dequeue();
            visit(v);
            for (int i = 0; i < adj.length; i++) {
                if (checked[i] != 1 && adj[v][i] == 1) {
                    checked[i] = 1;
                    queue.enqueue(i);
                }
            }
        }
    }

    private void visit(int n) {
        System.out.printf("visit %d%n", n);
    }

}
