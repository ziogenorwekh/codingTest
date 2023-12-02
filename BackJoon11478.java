import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BackJoon11478 {

    public static void main(String[] args) throws IOException {
        Set<String> differentString = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string = br.readLine();

        int k = 1;
        for (int i = 0; i < string.length(); i++) {
            try {
                for (int j = 0; j < string.length(); j++) {
                    differentString.add(string.substring(j, j + k));
                }
            } catch (StringIndexOutOfBoundsException ignored) {
            }
            k++;
        }
//        이게 올바른 정답
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i + 1; j <= str.length(); j++) {
//                set.add(str.substring(i, j));
//            }
//        }

        System.out.println(differentString.size());
    }
}
