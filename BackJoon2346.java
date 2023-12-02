import java.io.*;
import java.util.*;

public class BackJoon2346 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String command = br.readLine();
        StringTokenizer st = new StringTokenizer(command, " ");
        ArrayDeque<Balloon> balloons = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            balloons.add(new Balloon(i, Integer.valueOf(st.nextToken())));
        }
        List<Integer> answer = new ArrayList<>();

        while (balloons.size() != 1) {
            Balloon poll = balloons.poll();
            answer.add(poll.getSeq());
            int paperNum = poll.getPaperNum();
            if (paperNum > 0) {
                for (int i = 0; i < paperNum-1; i++) {
                    Balloon pollFirst = balloons.poll();
                    balloons.addLast(pollFirst);
                }
            } else {
                for (int i = 0; i < Math.abs(paperNum); i++) {
                    Balloon pollLast = balloons.pollLast();
                    balloons.addFirst(pollLast);
                }
            }
        }
        Balloon pop = balloons.pop();
        answer.add(pop.getSeq());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Integer ans : answer) {
            writer.write(ans + " ");
        }
        writer.close();

    }

    private static class Balloon {
        private int seq;
        private int paperNum;

        public Balloon(int seq, int paperNum) {
            this.seq = seq;
            this.paperNum = paperNum;
        }

        public int getSeq() {
            return seq;
        }

        public int getPaperNum() {
            return paperNum;
        }
    }
}
