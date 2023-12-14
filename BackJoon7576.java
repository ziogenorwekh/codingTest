import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon7576 {

    static int N;
    static int M;
    static StringTokenizer st;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M + 1; j++) {
                int var = Integer.parseInt(st.nextToken());
                graph[i][j] = var;
            }
        }
    }

    private static boolean dfs(int x, int y) {
        if (x < 1 || x >= N + 1 || y < 1 || y >= M + 1) {
            return false;
        }

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            
        }
        return false;
    }
}
