import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BackJoon2331 {

    static String D;
    static int P;
    static Map<Integer, Integer> seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        D = st.nextToken();
        P = Integer.parseInt(st.nextToken());
        seq = new HashMap<>();
        String var = D;
        int index = 0;
        int ans;
        seq.put(Integer.parseInt(D), index++);
        while (true) {
            int sequence = 0;
            for (int i = 0; i < var.length(); i++) {
                int num = Character.getNumericValue(var.charAt(i));
                sequence += (int) Math.pow(num, P);
            }
            if (seq.containsKey(sequence)) {
                ans = seq.get(sequence);
                break;
            }
            seq.put(sequence, index++);
            var = String.valueOf(sequence);
        }
        System.out.println(ans);
    }


}
