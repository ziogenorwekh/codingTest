import java.util.HashMap;
import java.util.Map;

public class programmers176963 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3},
                new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}});

    }

    private static class Solution2 {
        public static int[] solution(String[] name, int[] yearning, String[][] photo) {
            int[] answer = new int[photo.length];
            Map<String, Integer> score = new HashMap<>();
            for (int i = 0; i < name.length; i++) {
                score.put(name[i], yearning[i]);
            }
            for (int i = 0; i < photo.length; i++) {
                for (int j = 0; j < photo[i].length; j++) {
                    if (score.containsKey(photo[i][j])) {
                        int yearNum = score.get(photo[i][j]);
                        answer[i] += yearNum;
                    }
                }
            }
            return answer;
        }
    }

}

