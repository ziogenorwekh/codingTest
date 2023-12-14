import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        Stack<Integer> Coins = new Stack<>();
        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(br.readLine());
            Coins.add(coin);
        }
        while (K != 0) {
            int var = Coins.pop();
            if (K >= var) {
                result += (K / var);
                K = K % var;
            }
        }
        System.out.println(result);
    }
}
