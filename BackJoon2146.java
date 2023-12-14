import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 아직 못품
public class BackJoon2146 {

    static int N;
    static StringTokenizer st;
    static int[][] graph;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 1; x < N + 1; x++) {
            int count = 0;
            for (int y = 1; y < N + 1; y++) {
                if (searchMin(x, y)) {
                    count++;
                }
            }
            Math.min(result, count);
        }
        System.out.println(result);
    }


    private static boolean searchMin(int x, int y) {
//        if (graph[x + 1][y] == 1 || graph[x - 1][y] == 1 || graph[x][y + 1] == 1 || graph[x][y - 1] == 1) {
//            return true;
//        }
        if (x < 1 || x >= N + 1 || y < 1 || y >= N + 1) {
            return false;
        }

        if (graph[x][y] == 0) {

            searchMin(x - 1, y);
            searchMin(x + 1, y);
            searchMin(x, y + 1);
            searchMin(x, y - 1);
            return true;
        }

        return false;
    }
}
