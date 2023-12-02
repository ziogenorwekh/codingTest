import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon10815 {

    private static List<Integer> myCards = new ArrayList<>();
    private static List<Integer> checkCards = new ArrayList<>();
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String myCard = bf.readLine();
        StringTokenizer stN = new StringTokenizer(myCard, " ");
        for (int i = 0; i < N; i++) {
            myCards.add(Integer.parseInt(stN.nextToken()));
        }
        int M = Integer.parseInt(bf.readLine());
        String checkCard = bf.readLine();
        StringTokenizer stM = new StringTokenizer(checkCard, " ");
        for (int i = 0; i < M; i++) {
            checkCards.add(Integer.parseInt(stM.nextToken()));
        }

        myCards.sort(Comparator.naturalOrder());
        for (int i = 0; i < checkCards.size(); i++) {
            int cards = isCards(checkCards.get(i), 0, myCards.size() - 1);
            answer.add(cards == -1 ? 0 : 1);
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    private static int isCards(int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == myCards.get(mid)) {
                return mid;
            }  else if (key < myCards.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
