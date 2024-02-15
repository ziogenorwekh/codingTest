import java.io.*;
import java.util.*;

// 못품
public class BackJoon1456 {

    static long N;
    static long M;
    static long[] nearPrime;
    static long[] prime;

    static int result = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        searchPrime();

        for (int i = 0; i <= 10000000; i++) {
            if (nearPrime[i] < N || nearPrime[i] > M) continue;
            if (nearPrime[i] != 0) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void searchPrime() {

        prime = new long[10000001];
        nearPrime = new long[10000001];

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i] == i) continue;
            for (int j = i * i; j < prime.length-1; j = j + i) {
                prime[j] = j;
            }
        }
        for (int i = 2; i <= Math.sqrt(prime.length-1); i++) {
            if (nearPrime[i]== i) continue;
            for (int j = i * i; j < nearPrime.length-1; j = j * i) {
                if (prime[i] != i) {
                    nearPrime[j] = j;
                }
            }
        }
    }
}
