import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoon1463 {

    static int N;
    static int result = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N != 1) {
            if (N % 3 != 0) {
                N -= 1;
                result++;
                continue;
            } else {
                N /= 3;
                result++;
            }
            if (N == 2 || N == 3) {
                result++;
                break;
            }
        }

        System.out.println(result);
    }


}
