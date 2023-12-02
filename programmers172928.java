import java.util.StringTokenizer;

public class programmers172928 {
    public static void main(String[] args) {
        Solution solution3 = new Solution();
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        int[] result = solution3.solution(park, routes);
        System.out.println("Result: (" + result[0] + ", " + result[1] + ")");
    }

    private static class Solution {
        public int[] solution(String[] park, String[] routes) {
            char[][] map = new char[park.length][];
            int startColumn = -1;
            int startRow = -1;
            for (int i = 0; i < park.length; i++) {
                int searchStartPoint = park[i].indexOf('S');
                if (searchStartPoint != -1) {
                    startColumn = searchStartPoint;
                    startRow = i;
                }
                map[i] = park[i].toCharArray();
            }
            Mover mover = new Mover(startRow, startColumn);
            System.out.println("(" + mover.getRow() + "," + mover.getCol() + ")");

            for (int i = 0; i < routes.length; i++) {
                StringTokenizer st = new StringTokenizer(routes[i], " ");
                String direction = st.nextToken();
                int distance = Integer.parseInt(st.nextToken());
            }
            return new int[]{mover.getRow(), mover.getCol()};
        }

        private void move() {
            
        }

        private class Mover {
            private int row;
            private int col;

            public Mover(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public void setCol(int col) {
                this.col = col;
            }

            public void setRow(int row) {
                this.row = row;
            }

            public int getRow() {
                return row;
            }

            public int getCol() {
                return col;
            }
        }
    }
}

