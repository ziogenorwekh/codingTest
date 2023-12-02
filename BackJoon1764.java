import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1764 {

    private static Map<String, String> dontHeardPerson = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();

        List<String> answer = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(NM, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String dontHeardMan = br.readLine();
            dontHeardPerson.put(dontHeardMan,dontHeardMan);
        }
        for (int i = 0; i < M; i++) {
            String dontKnowMan = br.readLine();
            if (dontHeardPerson.containsKey(dontKnowMan)) {
                answer.add(dontHeardPerson.get(dontKnowMan));
            }
        }

        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for (String a: answer) {
            System.out.println(a);
        }
    }
}
