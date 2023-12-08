import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon2606 {

    static int N;
    static int E;

    static boolean[] visited;
    static List<Integer>[] A;
    static StringTokenizer st;

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        A = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            A[n1].add(n2);
            A[n2].add(n1);
        }
        dfs(1);
        System.out.println(ans);
    }


    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int i = 0; i < A[start].size(); i++) {
            int adj = A[start].get(i);
            if (!visited[adj]) {
                ans++;
                dfs(adj);
            }
        }
    }


}
