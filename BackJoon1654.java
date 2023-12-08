import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 해결못함
public class BackJoon1654 {

    static int K;
    static int N;
    static int[] LAN;

    static StringTokenizer st;
    static int Max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        LAN = new int[K];
        for (int i = 0; i < K; i++) {
            LAN[i] = Integer.parseInt(br.readLine());
            Max += LAN[i];
        }
        Arrays.sort(LAN);

        System.out.println(search(Max/N));
    }


    private static int search(int key) {
        int result = 0;
        while (key > 0) {
            int lanCount = 0;
            for (int i = 0; i < LAN.length; i++) {
                lanCount += (LAN[i] / key);
            }
            if (lanCount >= N) {
                result = key;
                break;
            }
            key--;
        }
        return result;
    }
}

