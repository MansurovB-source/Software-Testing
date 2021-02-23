import DFS.Graph;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Behruz Mansurov
 */
public class BfsTest {
    private static int n = 0;
    private static int num = 1;
    private static ArrayList<LinkedList<Integer>> data;
    private static int[] parent;
    private static boolean[] visited;
    private static int start;

    @Before
    public void init() {
        try (Scanner in = new Scanner(new BufferedInputStream(new FileInputStream("BfsTestData_" + num)))) {
            String s = in.nextLine();
            String[] s_elements = s.split(" ");
            n = Integer.parseInt(s_elements[0]);
            parent = new int[n + 1];
            visited = new boolean[n + 1];
            data = new ArrayList<>(n + 1);
            for (int i = 0; i <= n + 3; i++) {
                s = in.nextLine();
                s_elements = s.split(" ");
                if (i == 0) {
                    for (String s_e : s_elements) {
                        start = Integer.parseInt(s_e);
                    }
                } else if (i == n + 2) {
                    int k = 0;
                    for (String s_e : s_elements) {
                        parent[k] = Integer.parseInt(s_e);
                        k++;
                    }
                } else if (i == n + 3) {
                    int k = 0;
                    for (String s_e : s_elements) {
                        visited[k] = Boolean.parseBoolean(s_e);
                        k++;
                    }
                } else {
                    LinkedList<Integer> elements = new LinkedList<>();
                    if(!s_elements[0].equals("")) {
                        for (String s_e : s_elements) {
                            elements.add(Integer.parseInt(s_e));
                        }
                    }
                    data.add(elements);
                }
            }
            num++;
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void test_1() {
        Graph graph = new Graph(n + 1, data);
        graph.BFS(start);
        System.out.println();
        Assert.assertArrayEquals(parent, graph.getP());
        Assert.assertArrayEquals(visited, graph.getVisited());
    }

    @Test
    public void test_2() {
        Graph graph = new Graph(n + 1, data);
        graph.BFS(start);
        System.out.println();
        Assert.assertArrayEquals(parent, graph.getP());
        Assert.assertArrayEquals(visited, graph.getVisited());
    }

    @Test
    public void test_3() {
        Graph graph = new Graph(n + 1, data);
        graph.BFS(start);
        System.out.println();
        Assert.assertArrayEquals(parent, graph.getP());
        Assert.assertArrayEquals(visited, graph.getVisited());
    }

}
