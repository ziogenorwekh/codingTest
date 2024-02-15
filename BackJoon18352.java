import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon18352 {

    static int N;
    static int M;
    static int K;
    static int X;
    static List<Integer>[] A;
    static int[] visited;
    static StringTokenizer st;
    static boolean no = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new List[M + 1];

        for (int i = 1; i < M + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        visited = new int[M + 1];
        for (int i = 1; i < M + 1; i++) {
            visited[i] = -1;
        }
        bfs(1);

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == K) {
                no = true;
                System.out.println(i);
            }
        }

        if (!no) {
            System.out.println(-1);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[start]++;
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = 0; i < A[poll].size(); i++) {
                int adj = A[poll].get(i);
                if (visited[adj] == -1) {
                    visited[adj] = visited[poll] + 1;
                    queue.add(adj);
                }
            }
        }
    }
}
