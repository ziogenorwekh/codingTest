import java.util.ArrayList;
import java.util.List;

public class programmers178871 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answers = solution.solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(answers);
    }

    private static class Solution {
        public static String[] solution(String[] players, String[] callings) {
            List<String> list = new ArrayList<>();

            for (String player : players) {
                list.add(player);
            }
            for (int i = 0; i < callings.length; i++) {
                int index = list.indexOf(callings[i]);
                list.add(index - 1, callings[i]);
                list.remove(index + 1);
                System.out.println(list);
            }
            return list.toArray(new String[0]);

        }
    }
}

