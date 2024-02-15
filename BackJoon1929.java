import java.io.*;
import java.util.StringTokenizer;

public class BackJoon1929 {


    static boolean[] prime;
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        search();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                bw.write(i + "\n");
            }
        }
        bw.close();
    }

    private static void search() {

        prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= N; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
