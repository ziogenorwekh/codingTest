import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1260 {

    static int N;
    static int E;
    static int startNum;

    static StringTokenizer st;

    static List<Integer>[] A;
    static boolean[] visited;

    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startNum = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        A = new List[N + 1];
        queue = new ArrayDeque<>();

        for (int i = 0; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int E1 = Integer.parseInt(st.nextToken());
            int E2 = Integer.parseInt(st.nextToken());
            A[E1].add(E2);
            A[E2].add(E1);
        }

        dfs(startNum);
        visited = new boolean[N + 1];
        System.out.println();
        bfs(startNum);
    }

    private static void dfs(int startNum) {
        if (visited[startNum]) {
            return;
        }
        System.out.print(startNum + " ");
        visited[startNum] = true;
        for (int i = 0; i < A[startNum].size(); i++) {
            Collections.sort(A[startNum]);
            int adj = A[startNum].get(i);
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    private static void bfs(int start) {
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 0; i < A[start].size(); i++) {
                Collections.sort(A[start]);
                int adj = A[start].get(i);
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

}
