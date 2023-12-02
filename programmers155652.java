import java.util.LinkedList;

public class programmers155652 {


    public static void main(String[] args) {
        System.out.println(Solution.solution("aukks", "wbqd", 5));
    }


    private static class Solution {
        public static String solution(String s, String skip, int index) {
            StringBuilder answer = new StringBuilder();
            char[] sArr = s.toCharArray();

            LinkedList<Character> abcArr = new LinkedList<>();
            for (int i = 97; i <= 122; i++) {
                abcArr.add((char)i);
            }

            for (int i = 0; i < skip.length(); i++) {
                char c = skip.charAt(i);
                abcArr.remove(Character.valueOf(c));
            }

            for (char c : sArr) {
                int newIndex = abcArr.indexOf(c) + index;
//                newIndex가 abcArr의 길이를 계속 넘는 경우가 있음.
                while (newIndex >= abcArr.size()) {
                    newIndex -= abcArr.size();
                }
//                if (newIndex >= abcArr.size()) {
//                    newIndex = newIndex - abcArr.size();
//                }
                answer.append(abcArr.get(newIndex));
            }

            return answer.toString();
        }
    }
}
