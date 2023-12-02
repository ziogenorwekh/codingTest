import java.util.Scanner;

public class SieveOfEratosthenes {

    public static boolean[] prime;    // 소수를 체크할 배열

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        make_prime(N);

        for (int i = 0; i < prime.length; i++) {
            if (!prime[i]) {    // 소수(false)일 경우 출력
                System.out.println(i);
            }
        }
    }

    public static void make_prime(int N) {

        prime = new boolean[N + 1];    // 0 ~ N
		/*
		소수가 아닌 index = true
		소수인 index = false
		*/
        if (N < 2) return;
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if (prime[i]) continue;

            // i 의 배수들을 걸러주기 위한 반복문
            for (int j = i * i; j < prime.length; j = j + i) {
                prime[j] = true;
            }
        }
    }
}
