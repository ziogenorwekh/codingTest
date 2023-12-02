import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon14888 {

    private static int N;
    private static int[] seq;
    private static int[] op;
    private static StringTokenizer st;
    private static List<Integer> answer;
    private static char[] tempAns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        op = new int[4];
        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        tempAns = new char[N - 1];

        searchAllResult(0);
        Collections.sort(answer, Comparator.naturalOrder());

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    private static void searchAllResult(int start) {
        if (start == N - 1) {
            int totalResult = seq[0];
            for (int i = 0; i < tempAns.length; i++) {
                int var2 = seq[i + 1];
                totalResult = Operator(tempAns[i], totalResult, var2);
            }
            answer.add(totalResult);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i] -= 1;
            char operator = searchOperator(i);
            tempAns[start] = operator;
            searchAllResult(start + 1);
            op[i] += 1;
        }
    }

    private static char searchOperator(int var) {
        switch (var) {
            case 0:
                return '+';
            case 1:
                return '-';
            case 2:
                return 'x';
            case 3:
                return '/';
            default:
                throw new RuntimeException();
        }
    }

    private static int Operator(char op, int var1, int var2) {
        switch (op) {
            case '+':
                return var1 + var2;
            case '-':
                return var1 - var2;
            case 'x':
                return var1 * var2;
            case '/':
                return var1 / var2;
            default:
                throw new RuntimeException();
        }
    }

}
