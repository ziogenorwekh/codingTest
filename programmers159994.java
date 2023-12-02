import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class programmers159994 {
    public static void main(String[] args) {
        String solution = Solution5.solution(new String[]{"i", "drink", "water"},
                new String[]{"want", "to"}, new String[]{"i", "want", "drink", "to", "water"});
        String solution2 = Solution5.solution(new String[]{"i", "water", "drink"},
                new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(Solution5.solution(cards1, cards2, goal));

        System.out.println(solution);
        System.out.println(solution2);
    }

    private static class Solution5 {
        public static String solution(String[] cards1, String[] cards2, String[] goal) {
            List<String> cards1List = new ArrayList<>();
            List<String> cards2List = new ArrayList<>();

            cards1List.addAll(Arrays.asList(cards1));
            cards2List.addAll(Arrays.asList(cards2));

            for (int i = 0; i < goal.length; i++) {
                if (!cards1List.isEmpty() && cards1List.get(0).equals(goal[i])) {
                    cards1List.remove(0);
                } else if (!cards2List.isEmpty() && cards2List.get(0).equals(goal[i])) {
                    cards2List.remove(0);
                } else {
                    return "No";
                }
            }

            return "YES";
        }
    }
}
