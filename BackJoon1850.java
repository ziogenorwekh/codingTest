import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon1850 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = gcd(Math.max(A, B), Math.min(A, B));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }

    private static long gcd(long max, long min) {
        if (min == 0) {
            return max;
        }
        long gcded = Math.floorMod(max, min);
        return gcd(min, gcded);
    }
}
