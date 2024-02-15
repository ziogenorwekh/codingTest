import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1747 {

    static int N;
    static boolean[] check;
    static int result = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        prime();
        for (int i = N; i < 10000000; i++) {
            if (!check[i]) {
                int var = i;
                char[] charArray = String.valueOf(var).toCharArray();
                int j = 0;
                int k = charArray.length - 1;
                boolean success = true;
                while (j < k) {
                    if (charArray[j] != charArray[k]) {
                        success = false;
                    }
                    j++;
                    k--;
                }
                if (success) {
                    result = var;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static void prime() {

        check = new boolean[10000001];

        check[0] = check[1] = true;

        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (check[i]) continue;
            for (int j = i * i; j <= 10000000; j = j + i) {
                check[j] = true;
            }
        }
    }

}
