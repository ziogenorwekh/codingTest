//import java.io.*;
//import java.util.StringTokenizer;
//
//// 배열 값을 키워야 됌
//public class Testing {
//
//    static long N;
//    static long M;
//    static boolean[] nearPrime;
//    static boolean[] prime;
//    static int result = 0;
//
//    public static void main(String args[]) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Long.parseLong(st.nextToken());
//        M = Long.parseLong(st.nextToken());
//
//        searchPrime();
//
//        for (long i = N; i <= M; i++) {
//            if (nearPrime[(int) i]) {
//                result++;
//            }
//        }
//        System.out.println(result);
//    }
//
//    private static void searchPrime() {
//
//        prime = new boolean[(M + 1)];
//        nearPrime = new boolean[(M + 1)];
//        prime[0] = prime[1] = true;
//        for (int i = 2; i <= Math.sqrt(M); i++) {
//            if (prime[i]) continue;
//            for (int j = i * i; j <= M; j = j + i) {
//                prime[j] = true;
//            }
//        }
//        for (int i = 2; i < Math.sqrt(M); i++) {
//            if (nearPrime[i]) continue;
//            for (int j = i * i; j <= M; j = j * i) {
//                if (!prime[i]) {
//                    nearPrime[j] = true;
//                }
//            }
//        }
//    }
//}
