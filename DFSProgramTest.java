import java.util.ArrayList;
import java.util.List;

public class DFSProgramTest {


    static boolean[] visited;
    static List<Integer>[] A;
    static List<Integer> ans;

    public static void main(String[] args) {
        int N = 6;
        int E = 5;
        ans = new ArrayList<>();
        A = new List[N + 1];
        for (int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        A[5].add(1);
        A[1].add(2);
        A[1].add(3);
        A[2].add(4);
        A[2].add(3);
        A[3].add(4);
//        A[4].add(6);
        DFS(1, 2);
        for (Integer a : ans) {
            System.out.print(a + " -> ");
        }
        System.out.println();
        for (int i = 0; i < visited.length; i++) {
            System.out.print(String.valueOf(visited[i]) + ", ");
        }
    }

    static void DFS(int start, int destination) {
        if (visited[start]) {
            return;
        }
        ans.add(start);
        visited[start] = true;
        for (int i = 0; i < A[start].size(); i++) {
            int adj = A[start].get(i);
            System.out.println(String.format("start, i, adj = %d, %d, %d",start, i, adj));
            if (!visited[adj]) {
                DFS(adj, destination);
            }
        }
    }
}
