public class programmers161989 {

    public static void main(String[] args) {
        System.out.println(Solution4.solution(8, 4, new int[]{2, 3, 6}));
    }

    private static class Solution4 {
        public static int solution(int n, int m, int[] section) {

            int answer = 0;
            int[] arr = new int[n];

            for (int i = 0; i < section.length; i++) {
                arr[section[i] - 1] = -1;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == -1) { // 1
                    answer += 1;
                    i += m - 1; // 5
                }
            }

            return answer;
        }
    }
}
