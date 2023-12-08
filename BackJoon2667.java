import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BackJoon2667 {

    static int N;
    static int[][] graph;

    static int total = 0;
    static int count = 0;
    static List<Integer> houseGroups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        houseGroups = new ArrayList<>();
        graph = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                char var = line.charAt(j - 1);
                graph[i][j] = Character.getNumericValue(var);
            }
        }

        for (int x = 1; x < N + 1; x++) {
            for (int y = 1; y < N + 1; y++) {
                if (dfs(x, y)) {
                    count++;
                    houseGroups.add(total);
                    total = 0;
                }
            }
        }
        Collections.sort(houseGroups, Comparator.naturalOrder());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");
        for (int ans : houseGroups) {
            bw.write(ans + "\n");
        }
        bw.close();
    }

    private static boolean dfs(int x, int y) {
        if (x <= -1 || x >= N + 1 || y <= -1 || y >= N + 1) {
            return false;
        }

        if (graph[x][y] == 1) {
            total++;
            graph[x][y] = 0;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

}
