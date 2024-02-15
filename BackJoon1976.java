import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1976 {

    static int[] union;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        union = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            union[i] = i;
        }

        for (int i = 1; i < N + 1; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int var = Integer.parseInt(split[j]);
                if (var == 1) {
                    union(i, j + 1);
                }
            }
        }

        for (int i = 1; i < union.length; i++) {
            System.out.print(union[i] + " ");
        }
    }

    private static int find(int x) {
        if (union[x] != x) {
            union[x] = find(union[x]);
        }
        return union[x];
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            union[y] = x;
        }
    }
}
