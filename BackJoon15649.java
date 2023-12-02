import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon15649 {

    static int[] result;
    static boolean[] visited;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        dfs(0);
    }


    private static void dfs(int start) {
        if (start == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            result[start] = i + 1;
            visited[i] = true;
            dfs(start + 1);
            visited[i] = false;
        }
    }
}
