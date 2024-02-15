import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon1934 {
    static StringTokenizer st;
    static List<Integer> answer;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int gcd = gcd(i2, i1);
            int lcm = (Math.abs(i1) * Math.abs(i2) / gcd);
            answer.add(lcm);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int ans : answer) {
            bw.write(ans + "\n");
        }
        bw.close();
    }

    private static int gcd(int max, int min) {
        if (min == 0) {
            return max;
        }
        int gcded = Math.floorMod(max, min);
        return gcd(min, gcded);
    }
}
