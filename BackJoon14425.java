import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 못품
public class BackJoon14425 {

    static int answer = 0;
    static List<String> Nwords = new ArrayList<>();
    static List<String> Mwords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        StringTokenizer st = new StringTokenizer(NM, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            Nwords.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            Mwords.add(br.readLine());
        }

    }


}
