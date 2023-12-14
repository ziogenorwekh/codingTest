import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 못품
public class BackJoon2468 {

    static int N;
    static int[][] graph;
    static boolean[][] visited;

    static StringTokenizer st;

    static int MAX = 0;
    static int MIN = Integer.MAX_VALUE;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                MAX = Math.max(MAX, num);
                MIN = Math.min(MIN, num);
                graph[i][j] = num;
            }
        }

        for (int i = 0; i <= MAX; i++) {
            visited = new boolean[N + 1][N + 1];
            int count = 0;
            for (int x = 1; x < N + 1; x++) {
                for (int y = 1; y < N + 1; y++) {
                    if (graph[x][y] > i && !visited[x][y]) {
                        search(x, y, i);
                        count++;
                    }
                }
            }
            System.out.println("i="+i+", count = " + count);
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    private static void search(int x, int y, int height) {
        if (x < 1 || x >= N + 1 || y < 1 || y >= N + 1) {
            return;
        }

        if (graph[x][y] > height && !visited[x][y]) {
            visited[x][y] = true;

            search(x - 1, y, height);
            search(x + 1, y, height);
            search(x, y - 1, height);
            search(x, y + 1, height);
        }
    }
}

