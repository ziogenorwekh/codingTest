import java.io.*;
import java.util.StringTokenizer;

public class BackJoon15651 {
    static int N;
    static int M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        dfs(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }

    private static void dfs(int start) {
        if (start == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            result[start] = i + 1;
            dfs(start + 1);
        }
    }
}
