package DFS;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class Graph {
    private boolean[] visited;
    private int[] p;
    private int[] d;

    private int nodes;
    private ArrayList<LinkedList<Integer>> edges;

    public Graph(int nodes) {
        this.nodes = nodes;
        edges = new ArrayList<>();
        visited = new boolean[nodes];
        p = new int[nodes];
        d = new int[nodes];
    }

    public Graph(int nodes, ArrayList<LinkedList<Integer>> edges) {
        this.nodes = nodes;
        this.edges = edges;
        visited = new boolean[nodes];
        p = new int[nodes];
        d = new int[nodes];
        Arrays.fill(p, -1);
        Arrays.fill(d, 0);
        Arrays.fill(visited, false);
    }

    public void addEdge(int v, int e) {
        edges.get(v).add(e);
    }

    public void BFS(int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        p[s] = -1;
        queue.add(s);

        while (queue.size() != 0) {
            int from = queue.poll();
            Iterator<Integer> i = edges.get(from).listIterator();
            while (i.hasNext()) {
                int to = i.next();
                if (!visited[to]) {
                    visited[to] = true;
                    queue.add(to);
                    d[to] = d[from] + 1;
                    p[to] = from;
                }
            }
        }
    }

    public boolean[] getVisited() {
        return visited;
    }

    public int[] getP() {
        return p;
    }

    public int[] getD() {
        return d;
    }
}
