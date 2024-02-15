import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1325 {

    static StringTokenizer st;
    static List<Integer>[] A;

    static boolean[] visited;
    static int[] ans;
    static int N;

    static int MAX = Integer.MIN_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new List[N + 1];
        ans = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
            ans[i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        for (int i = 1; i < N + 1; i++) {

            bfs(i);
        }

        for (int i = 0; i < ans.length; i++) {
            if (MAX < ans[i]) {
                MAX = ans[i];
            }
        }

        for (int i = 1; i < ans.length; i++) {
            if (MAX == ans[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < A[poll].size(); i++) {
                int adj = A[poll].get(i);
                if (visited[adj]) {
                    ans[adj]++;
                    queue.add(adj);
                }
            }
        }
    }
}
