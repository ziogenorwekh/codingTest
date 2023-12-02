import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon12789 {

    static String Nice = "Nice";
    static String Sad = "Sad";

    public static void main(String[] args) throws IOException {

        Stack<Integer> onlyPerOneLine = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String M = br.readLine();
        StringTokenizer st = new StringTokenizer(M, " ");


        int sequence = 1;
        Queue<Integer> tempList = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            tempList.add(Integer.parseInt(st.nextToken()));
        }

        // 조금 다르게 생각해야
        while (!tempList.isEmpty()) {
            Integer seq = tempList.peek();
            if (!onlyPerOneLine.empty() && onlyPerOneLine.peek() == sequence) {
                onlyPerOneLine.pop();
                sequence++;
            } else {
                if (seq == sequence) {
                    sequence++;
                } else {
                    onlyPerOneLine.push(seq);
                }
                tempList.poll();
            }
        }

        while (!onlyPerOneLine.empty()) {
            Integer pop = onlyPerOneLine.pop();
            if (pop == sequence) {
                sequence++;
            } else {
                System.out.println(Sad);
                return;
            }
        }
        System.out.println(Nice);
    }
}
