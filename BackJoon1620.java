import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BackJoon1620 {
    private static Map<String, String> pokemons = new HashMap<>();
    private static Map<String, String> reversePokemons = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();

        StringTokenizer st = new StringTokenizer(NM, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String pokemon = br.readLine();
            pokemons.put(pokemon, String.valueOf(i + 1));
            reversePokemons.put(String.valueOf(i + 1), pokemon);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (pokemons.containsKey(question)) {
                System.out.println(pokemons.get(question));
            } else if (reversePokemons.containsKey(question)) {
                System.out.println(reversePokemons.get(question));
            }
        }
    }

}
