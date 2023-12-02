import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BackJoon28278 {

    private static Stack<Integer> stack = new Stack<>();
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            checkCommand(br.readLine());
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer ans : answer) {
            writer.write(ans + "\n");
        }
        writer.close();
    }

    private static void checkCommand(String command) {
        switch (command.charAt(0)) {
            case '1':
                StringTokenizer st = new StringTokenizer(command, " ");
                st.nextToken();
                stack.push(Integer.parseInt(st.nextToken()));
                break;
            case '2':
                if (!stack.empty()) {
                    answer.add(stack.pop());
                } else {
                    answer.add(-1);
                }
                break;
            case '3':
                answer.add(stack.size());
                break;
            case '4':
                if (stack.empty()) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
                break;
            case '5':
                if (!stack.empty()) {
                    answer.add(stack.peek());
                } else {
                    answer.add(-1);
                }
                break;
            default:
                break;
        }
    }
}
