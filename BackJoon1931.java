import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 대기
public class BackJoon1931 {

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start < MIN) MIN = start;
            if (end > MAX) MAX = end;
            meetings.add(new Meeting(start, end));
        }
    }

    private static class Meeting {
        int start;
        int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
